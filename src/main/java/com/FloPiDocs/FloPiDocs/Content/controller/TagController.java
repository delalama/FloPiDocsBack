package com.FloPiDocs.FloPiDocs.Content.controller;

import com.FloPiDocs.FloPiDocs.Content.entities.Document;
import com.FloPiDocs.FloPiDocs.Content.entities.Tag;
import com.FloPiDocs.FloPiDocs.Content.service.DocumentService;
import com.FloPiDocs.FloPiDocs.Content.service.TagService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("tag")
@Controller
public class TagController {
        protected final Log logger = LogFactory.getLog(getClass());

        @Autowired
        private TagService tagService;
        @Autowired
        private DocumentService documentService;

        /*TODO REPASAR TODOS LOS NOMBRE DE LOS MAPPINGS
        GET
        POST create/update data
        * */
        @PostMapping(value = "/createTag", produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<String> createTag(
                @RequestParam("userId") String userId,
                @RequestParam("tagName") String tagName ,
                @RequestParam("documentId") String documentId) {
                logger.info("tag - createTag");

                Tag tag = new Tag(userId, documentId, tagName);
                tagService.save(tag);
                return new ResponseEntity<>("Added Tag: " + tagName, HttpStatus.OK);
        }

        @GetMapping("/getTagByDocumentId")
        public ResponseEntity<List<Tag>> getTagByDocumentId(
                @RequestParam("documentId") String documentId) {
                logger.info("tag - getTagByDocumentId");
                List<Tag> tagList = tagService.findByDocumentId(documentId);
                return new ResponseEntity<>(tagList, HttpStatus.OK);
        }
        //TODO ACTUAL INSERTAR VALORES REALES PARA LOS USERID
}
