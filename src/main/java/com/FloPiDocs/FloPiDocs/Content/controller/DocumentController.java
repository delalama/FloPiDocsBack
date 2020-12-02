package com.FloPiDocs.FloPiDocs.Content.controller;

import com.FloPiDocs.FloPiDocs.Content.model.persistence.Document;
import com.FloPiDocs.FloPiDocs.Content.model.dto.DocumentDTO;
import com.FloPiDocs.FloPiDocs.Content.service.DocumentService;
import com.FloPiDocs.FloPiDocs.Content.service.FieldService;
import com.FloPiDocs.FloPiDocs.Content.service.TagService;
import com.FloPiDocs.FloPiDocs.Content.service.UserService;
import com.itextpdf.text.DocumentException;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
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
     * @param documentDTO
     * @return documentDto
     */
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<DocumentDTO> createDocument(
            @RequestBody DocumentDTO documentDTO) {
        log.info("document - createDocument");
        DocumentDTO documentDTO1 = documentService.createDocument(documentDTO);
        return new ResponseEntity<>(documentDTO1, HttpStatus.OK);
    }

    /**
     * Export Document
     * @param documentId
     * @return
     * @throws FileNotFoundException
     * @throws DocumentException
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
     * @param title Title of document
     * @param userId
     * @return List<DocumentDto>
     */
    @GetMapping(value = "findByTitle")
    public ResponseEntity<List<DocumentDTO>> findByUserIdAndTitle(
            @RequestParam("key") String title,
            @RequestParam("userId") String userId) {
        List<DocumentDTO> documentList = documentService.findByUserIdAndTitle(userId, title);
        return new ResponseEntity<>(documentList, HttpStatus.OK);
    }

    /**
     * Find documents By Purpose
     * @param key
     * @param userId
     * @return
     */
    @GetMapping(value = "findByPurpose")
    public ResponseEntity<List<DocumentDTO>> findByUserIdAndPurpose(
            @RequestParam("key") String key,
            @RequestParam("userId") String userId) {
        List<DocumentDTO> documentList = documentService.findByUserIdAndPurpose(userId, key);
        return new ResponseEntity<>(documentList, HttpStatus.OK);
    }

    /**
     * Find documents By Tag
     * @param key
     * @param userId
     * @return List<DocumentDto>
     * @throws Exception
     */
    @GetMapping(value = "findByTag")
    public ResponseEntity<List<DocumentDTO>> findByUserIdAndTag(
            @RequestParam("key") String key,
            @RequestParam("userId") String userId) throws Exception {
        return new ResponseEntity<>(documentService.findByUserIdAndTag(userId, key), HttpStatus.OK);
    }

    /**
     * Delete document by documentID
     * @param documentDTO
     * @return
     * @throws Exception
     */
    @DeleteMapping
    public ResponseEntity<DocumentDTO> deleteDocumentById(
            @RequestBody DocumentDTO documentDTO) throws Exception {
        log.info("document - deleteDocumentById");
        return new ResponseEntity<>(documentService.deleteById(documentDTO), HttpStatus.OK);
    }

    /**
     * Get documents by purpose
     * @param purpose
     * @return List<DocumentDto>
     */
    @GetMapping("/getDocumentByPurpose")
    public ResponseEntity<List<DocumentDTO>> getDocumentByPurpose(
            @RequestParam("purpose") String purpose) {
        log.info("document - getDocumentByPurpose");
        List<DocumentDTO> documentList = documentService.findByPurpose(purpose);
        return new ResponseEntity<>(documentList, HttpStatus.OK);
    }

    /**
     * Update document data
     * @param documentDTO
     * @return updated documentDto
     * @throws Exception
     */
    @RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateDocumentContent(
            @RequestBody DocumentDTO documentDTO) throws Exception {
        log.info("document - updateDocument");
        documentService.update(documentDTO);
        return new ResponseEntity<>("Content updated: ", HttpStatus.OK);
    }

    /**
     * Get Document By Title
     * @param title
     * @return
     */
    @GetMapping("/getDocumentByTitle")
    public ResponseEntity<List<DocumentDTO>> getDocumentByTitle(
            @RequestParam("title") String title) {
        log.info("document - getDocumentByTitle");
        return new ResponseEntity<>(documentService.findByTitle(title), HttpStatus.OK);
    }

    /**
     * Get documents by userId
     * @param userId
     * @return List<DocumentDto>
     */
    @GetMapping
    public ResponseEntity<List<DocumentDTO>> getDocumentsByUserId(
            @RequestParam("userId") String userId) {
        log.info("document - getAllDocumentsByUserId");
        return new ResponseEntity<>(documentService.findAllByUserId(userId), HttpStatus.OK);
    }

    /**
     * Manager method
     * @return
     */
    @DeleteMapping("/deleteAll")
    public ResponseEntity<String> deleteAll() {
        log.info("document - deleteAll");
        documentService.deleteAll();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Not used
     * @param userId
     * @return
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
     * @param title
     * @return
     */
    @DeleteMapping("/deleteByTitle")
    public ResponseEntity<String> deleteAllByTitle(
            @RequestParam("title") String title) {
        log.info("document - deleteByTitle");
        documentService.deleteByTitle(title);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}