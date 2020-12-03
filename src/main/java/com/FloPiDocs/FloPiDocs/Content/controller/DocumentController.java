package com.FloPiDocs.FloPiDocs.Content.controller;

import com.FloPiDocs.FloPiDocs.Content.service.DocumentService;
import com.FloPiDocs.FloPiDocs.Content.service.FieldService;
import com.FloPiDocs.FloPiDocs.Content.service.TagService;
import com.FloPiDocs.FloPiDocs.Content.service.UserService;
import com.FloPiDocs.FloPiDocs.Content.model.dto.DocumentDto;
import com.itextpdf.text.DocumentException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.io.FileNotFoundException;
import java.util.List;

/**
 * The type Document controller.
 */
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

    /**
     * Create Document
     *
     * @param documentDTO the document dto
     * @return documentDto response entity
     */
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DocumentDto> createDocument(
            @RequestBody DocumentDto documentDTO) {
        log.info("document - createDocument");
        DocumentDto documentDTO1 = documentService.createDocument(documentDTO);
        return new ResponseEntity<>(documentDTO1, HttpStatus.OK);
    }

    /**
     * Export Document
     *
     * @param documentId the document id
     * @return response entity
     * @throws FileNotFoundException the file not found exception
     * @throws DocumentException     the document exception
     */
    @GetMapping(value = "exportDocument")
    public ResponseEntity<InputStreamResource> exportDocument(
            @RequestParam("documentId") String documentId) throws FileNotFoundException, DocumentException {

        var headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=FloPiDoc.pdf");

        return  ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(documentService.exportDocument(documentId)));
    }

    /**
     * Find documents by title
     *
     * @param title  Title of document
     * @param userId the user id
     * @return List<DocumentDto>  response entity
     */
    @GetMapping(value = "findByTitle")
    public ResponseEntity<List<DocumentDto>> findByUserIdAndTitle(
            @RequestParam("key") String title,
            @RequestParam("userId") String userId) {
        List<DocumentDto> documentList = documentService.findByUserIdAndTitle(userId, title);
        return new ResponseEntity<>(documentList, HttpStatus.OK);
    }

    /**
     * Find documents By Purpose
     *
     * @param key    the key
     * @param userId the user id
     * @return response entity
     */
    @GetMapping(value = "findByPurpose")
    public ResponseEntity<List<DocumentDto>> findByUserIdAndPurpose(
            @RequestParam("key") String key,
            @RequestParam("userId") String userId) {
        List<DocumentDto> documentList = documentService.findByUserIdAndPurpose(userId, key);
        return new ResponseEntity<>(documentList, HttpStatus.OK);
    }

    /**
     * Find documents By Tag
     *
     * @param key    the key
     * @param userId the user id
     * @return List<DocumentDto>  response entity
     * @throws Exception the exception
     */
    @GetMapping(value = "findByTag")
    public ResponseEntity<List<DocumentDto>> findByUserIdAndTag(
            @RequestParam("key") String key,
            @RequestParam("userId") String userId) throws Exception {
        return new ResponseEntity<>(documentService.findByUserIdAndTag(userId, key), HttpStatus.OK);
    }

    /**
     * Delete document by documentID
     *
     * @param documentDTO the document dto
     * @return response entity
     * @throws Exception the exception
     */
    @DeleteMapping
    public ResponseEntity<DocumentDto> deleteDocumentById(
            @RequestBody DocumentDto documentDTO) throws Exception {
        log.info("document - deleteDocumentById");
        return new ResponseEntity<>(documentService.deleteById(documentDTO), HttpStatus.OK);
    }

    /**
     * Get documents by purpose
     *
     * @param purpose the purpose
     * @return List<DocumentDto>  document by purpose
     */
    @GetMapping("/getDocumentByPurpose")
    public ResponseEntity<List<DocumentDto>> getDocumentByPurpose(
            @RequestParam("purpose") String purpose) {
        log.info("document - getDocumentByPurpose");
        List<DocumentDto> documentList = documentService.findByPurpose(purpose);
        return new ResponseEntity<>(documentList, HttpStatus.OK);
    }

    /**
     * Update document data
     *
     * @param documentDTO the document dto
     * @return updated documentDto
     * @throws Exception the exception
     */
    @RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateDocumentContent(
            @RequestBody DocumentDto documentDTO) throws Exception {
        log.info("document - updateDocument");
        documentService.update(documentDTO);
        return new ResponseEntity<>("Document updated: ", HttpStatus.OK);
    }

    /**
     * Get Document By Title
     *
     * @param title the title
     * @return document by title
     */
    @GetMapping("/getDocumentByTitle")
    public ResponseEntity<List<DocumentDto>> getDocumentByTitle(
            @RequestParam("title") String title) {
        log.info("document - getDocumentByTitle");
        return new ResponseEntity<>(documentService.findByTitle(title), HttpStatus.OK);
    }

    /**
     * Get documents by userId
     *
     * @param userId the user id
     * @return List<DocumentDto>  documents by user id
     */
    @GetMapping
    public ResponseEntity<List<DocumentDto>> getDocumentsByUserId(
            @RequestParam("userId") String userId) {
        log.info("document - getAllDocumentsByUserId");
        return new ResponseEntity<>(documentService.findAllByUserId(userId), HttpStatus.OK);
    }

    /**
     * Manager method
     *
     * @return response entity
     */
    @DeleteMapping("/deleteAll")
    public ResponseEntity<String> deleteAll() {
        log.info("document - deleteAll");
        documentService.deleteAll();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Not used
     *
     * @param userId the user id
     * @return response entity
     */
    @GetMapping("/countByUserId")
    public ResponseEntity<Long> countByUserId(
            @RequestParam("userId") String userId) {
        log.info("document - deleteAll");
        Long documentsCount = documentService.countByUserId(userId);
        return new ResponseEntity<>(documentsCount, HttpStatus.OK);
    }

    /**
     * Not used
     *
     * @param title the title
     * @return response entity
     */
    @DeleteMapping("/deleteByTitle")
    public ResponseEntity<String> deleteAllByTitle(
            @RequestParam("title") String title) {
        log.info("document - deleteByTitle");
        documentService.deleteByTitle(title);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}