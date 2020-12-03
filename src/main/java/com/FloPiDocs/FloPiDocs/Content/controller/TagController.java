package com.FloPiDocs.FloPiDocs.Content.controller;

import com.FloPiDocs.FloPiDocs.Content.service.TagService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The type Tag controller.
 */
@RequestMapping("tag")
@CrossOrigin
@RestController
@Slf4j
public class TagController {

    @Autowired
    private TagService tagService;

    /**
     * Create tag
     *
     * @param tagDTO the tag dto
     * @return tagDto response entity
     */
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<com.FloPiDocs.FloPiDocs.Content.model.dto.TagDto> createTag(
            @RequestBody com.FloPiDocs.FloPiDocs.Content.model.dto.TagDto tagDTO) {
        log.info("tag - createTag");
        return new ResponseEntity<>(tagService.save(tagDTO), HttpStatus.OK);
    }

    /**
     * Get tags by documentId
     *
     * @param documentId the document id
     * @return List<TagDto>  tag by document id
     */
    @GetMapping
    public ResponseEntity<List<com.FloPiDocs.FloPiDocs.Content.model.dto.TagDto>> getTagByDocumentId(
            @RequestParam("documentId") String documentId) {
        log.info("tag - getTagByDocumentId");
        return new ResponseEntity<>(tagService.findByDocumentId(documentId), HttpStatus.OK);
    }

    /**
     * Delete Tag by tagId
     *
     * @param tagId the tag id
     * @return tagDto response entity
     */
    @DeleteMapping
    public ResponseEntity<com.FloPiDocs.FloPiDocs.Content.model.dto.TagDto> deleteByTagId(
            @RequestParam("tagId") String tagId) {
        log.info("tag - deleteByTagId");
        return new ResponseEntity<>(tagService.deleteByTagId(tagId), HttpStatus.OK);
    }

    /**
     * Manager method
     *
     * @return response entity
     */
    @DeleteMapping("/deleteAll")
    public ResponseEntity<String> deleteAll() {
        log.info("tag - deleteAll");
        tagService.deleteAll();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
