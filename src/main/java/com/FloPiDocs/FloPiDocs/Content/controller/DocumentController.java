package com.FloPiDocs.FloPiDocs.Content.controller;

import com.FloPiDocs.FloPiDocs.Content.model.persistence.Document;
import com.FloPiDocs.FloPiDocs.Content.model.dto.DocumentDTO;
import com.FloPiDocs.FloPiDocs.Content.service.DocumentService;
import com.FloPiDocs.FloPiDocs.Content.service.FieldService;
import com.FloPiDocs.FloPiDocs.Content.service.TagService;
import com.FloPiDocs.FloPiDocs.Content.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@CrossOrigin
@RequestMapping("document")
@Controller
@Slf4j
public class DocumentController {
    @Autowired
    private DocumentService documentService;
    @Autowired
    private UserService userService;
    @Autowired
    private TagService tagService;
    @Autowired
    private FieldService fieldService;
    ModelMapper modelMapper = new ModelMapper();

    // https://graphql.org/
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DocumentDTO> createDocument(
            @RequestBody DocumentDTO documentDTO) {
        log.info("document - createDocument");
        DocumentDTO documentDTO1 = documentService.createDocument(documentDTO);
        return new ResponseEntity<>(documentDTO1, HttpStatus.OK);
    }


    @GetMapping("/getDocumentByTitle")
    public ResponseEntity<List<Document>> getDocumentByTitle(
            @RequestParam("title") String title) {
        log.info("document - getDocumentByTitle");
        return new ResponseEntity<>(documentService.findByTitle(title), HttpStatus.OK);
    }

    @GetMapping(value = "findByTitle")
    public ResponseEntity<List<Document>> findByUserIdAndTitle(
            @RequestParam("key") String key,
            @RequestParam("userId") String userId) {
        List<Document> documentList = documentService.findByUserIdAndTitle(userId, key);
        return new ResponseEntity<>(documentList, HttpStatus.OK);
    }

    @GetMapping(value = "findByPurpose")
    public ResponseEntity<List<Document>> findByUserIdAndPurpose(
            @RequestParam("key") String key,
            @RequestParam("userId") String userId) {
        List<Document> documentList = documentService.findByUserIdAndPurpose(userId, key);
        return new ResponseEntity<>(documentList, HttpStatus.OK);
    }

    @GetMapping(value = "findByTag")
    public ResponseEntity<List<DocumentDTO>> findByUserIdAndTag(
            @RequestParam("key") String key,
            @RequestParam("userId") String userId) throws Exception {
        return new ResponseEntity<>(documentService.findByUserIdAndTag(userId, key), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<DocumentDTO> deleteDocumentById(
            @RequestBody DocumentDTO documentDTO) throws Exception {
        log.info("document - deleteDocumentById");
        return new ResponseEntity<>(documentService.deleteById(documentDTO), HttpStatus.OK);
    }

//    TODO ACTUAL
    @GetMapping("/getDocumentByPurpose")
    public ResponseEntity<List<Document>> getDocumentByPurpose(
            @RequestParam("purpose") String purpose) {
        log.info("document - getDocumentByPurpose");
        List<Document> documentList = documentService.findByPurpose(purpose);
        return new ResponseEntity<>(documentList, HttpStatus.OK);
    }

    //TODO page por parámetro
    @GetMapping
    public ResponseEntity<List<DocumentDTO>> getDocumentsByUserId(
            @RequestParam("userId") String userId) {
        log.info("document - getAllDocumentsByUserId");
        return new ResponseEntity<>(documentService.findAllByUserId(userId), HttpStatus.OK);
    }

    //TODO
    @GetMapping("/countByUserId")
    public ResponseEntity<Long> countByUserId(
            @RequestParam("userId") String userId) {
        log.info("document - deleteAll");
        Long documentsCount = documentService.countByUserId(userId);
        return new ResponseEntity<>(documentsCount, HttpStatus.OK);
    }

    //TODO
    @DeleteMapping("/deleteAll")
    public ResponseEntity<String> deleteAll() {
        log.info("document - deleteAll");
        documentService.deleteAll();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/deleteByTitle")
    public ResponseEntity<String> deleteAllByTitle(
            @RequestParam("title") String title) {
        log.info("document - deleteByTitle");
        documentService.deleteByTitle(title);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateDocumentContent(
            @RequestBody DocumentDTO documentDTO) throws Exception {
        log.info("document - updateDocument");
        documentService.update(documentDTO);
        return new ResponseEntity<>("Content updated: ", HttpStatus.OK);
    }
}