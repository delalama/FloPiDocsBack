package com.FloPiDocs.FloPiDocs.Content.controller;

import com.FloPiDocs.FloPiDocs.Content.model.dto.TagDTO;
import com.FloPiDocs.FloPiDocs.Content.service.TagService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("tag")
@CrossOrigin
@RestController
@Slf4j
public class TagController {

    @Autowired
    private TagService tagService;

    /*TODO REPASAR TODOS LOS NOMBRE DE LOS MAPPINGS
    GET
    POST create/update data
    * */
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TagDTO> createTag(
            @RequestBody TagDTO tagDTO) {
        log.info("tag - createTag");
        return new ResponseEntity<>(tagService.save(tagDTO), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<TagDTO>> getTagByDocumentId(
            @RequestParam("documentId") String documentId) {
        log.info("tag - getTagByDocumentId");
        return new ResponseEntity<>(tagService.findByDocumentId(documentId), HttpStatus.OK);
    }

    //TODO
    @DeleteMapping
    public ResponseEntity<TagDTO> deleteByTagId(
            @RequestParam("tagId") String tagId) {
        log.info("tag - deleteByTagId");
        return new ResponseEntity<>(tagService.deleteByTagId(tagId), HttpStatus.OK);
    }

    //TODO
    @DeleteMapping("/deleteAll")
    public ResponseEntity<String> deleteAll() {
        log.info("tag - deleteAll");
        tagService.deleteAll();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
