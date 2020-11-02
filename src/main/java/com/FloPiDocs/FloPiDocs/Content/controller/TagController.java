package com.FloPiDocs.FloPiDocs.Content.controller;

import com.FloPiDocs.FloPiDocs.Content.entities.Tag;
import com.FloPiDocs.FloPiDocs.Content.service.TagService;
import com.FloPiDocs.FloPiDocs.FloPiDocsApplication;
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

        @Autowired
        private TagService tagService;

        /*TODO REPASAR TODOS LOS NOMBRE DE LOS MAPPINGS
        GET
        POST create/update data
        * */
        @PostMapping(value = "/createTag", produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<String> createTag(
                @RequestParam("userId") String userId,
                @RequestParam("tagName") String tagName ,
                @RequestParam("documentId") String documentId) {
                FloPiDocsApplication.logger.info("tag - createTag");

                Tag tag = new Tag(userId, documentId, tagName);
                tagService.save(tag);
                return new ResponseEntity<>("Added Tag: " + tagName, HttpStatus.OK);
        }

        @GetMapping("/getTagByDocumentId")
        public ResponseEntity<List<Tag>> getTagByDocumentId(
                @RequestParam("documentId") String documentId) {
                FloPiDocsApplication.logger.info("tag - getTagByDocumentId");
                List<Tag> tagList = tagService.findByDocumentId(documentId);
                return new ResponseEntity<>(tagList, HttpStatus.OK);
        }

        //TODO
        @DeleteMapping("/deleteAll")
        public ResponseEntity<String> deleteAll() {
                FloPiDocsApplication.logger.info("tag - deleteAll");
                tagService.deleteAll();
                return new ResponseEntity<>( HttpStatus.OK);
        }

        //TODO ACTUAL INSERTAR VALORES REALES PARA LOS USERID
}
