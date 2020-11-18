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
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

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
    @PostMapping(value = "/createDocument", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Document> createDocument(
            @RequestParam("userId") String userId, @RequestParam("title") String title,
            @RequestParam("purpose") String purpose,
            @RequestParam("content") String content) {
        log.info("document - createDocument");
        Document document = new Document();
        //Guille , cómo responder lo adecuado a cada CASE?
        if (userId.equals("")) {
            return new ResponseEntity<>(document, HttpStatus.CONFLICT);
        } else if (title.equals("")) {
            return new ResponseEntity<>(document, HttpStatus.CONFLICT);
        } else if (purpose.equals("")) {
            return new ResponseEntity<>(document, HttpStatus.CONFLICT);
        }
        // formated date
        DateTimeFormatter formmat1 = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
        LocalDateTime ldt = LocalDateTime.now();
        String formatedDate = formmat1.format(ldt);

        document = new Document(userId, title, purpose, content, formatedDate);
        document = documentService.createDocument(document);
        return new ResponseEntity<>(document, HttpStatus.OK);
    }


    @GetMapping("/getDocumentByTitle")
    public ResponseEntity<List<Document>> getDocumentByTitle(
            @RequestParam("title") String title) {

        log.info("document - getDocumentByTitle");
        List<Document> documentList = documentService.findByTitle(title);
        return new ResponseEntity<>(documentList, HttpStatus.OK);
    }

    @GetMapping(value = "findByTitle")
    public ResponseEntity<List<Document>> findByUserIdAndTitle(
            @RequestParam("key") String key,
            @RequestParam("userId") String userId) {
        log.info("document - searchBar");
        log.info("string Title : " + key);
        log.info("userId : " + userId);

        List<Document> documentList = documentService.findByUserIdAndTitle(userId, key);
        return new ResponseEntity<>(documentList, HttpStatus.OK);
    }

    @GetMapping(value = "findByPurpose")
    public ResponseEntity<List<Document>> findByUserIdAndPurpose(
            @RequestParam("key") String key,
            @RequestParam("userId") String userId) {
        log.info("document - searchBar");
        log.info("string Purpose : " + key);
        log.info("userId : " + userId);

        List<Document> documentList = documentService.findByUserIdAndPurpose(userId, key);
        return new ResponseEntity<>(documentList, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<DocumentDTO> deleteDocumentById(
            @RequestBody DocumentDTO documentDTO) throws Exception {
        log.info("document - deleteDocumentById");
        System.out.println(documentDTO);
        DocumentDTO documentDTO1 = documentService.deleteById(documentDTO);

        //TODO ACTUAL, ELIMINAR TODO EL CONTENIDO DEL DOCUMENTO BORRADO
        return new ResponseEntity<DocumentDTO>(documentDTO1, HttpStatus.OK );
    }

    @GetMapping("/getDocumentByPurpose")
    public ResponseEntity<List<Document>> getDocumentByPurpose(
            @RequestParam("purpose") String purpose) {
        log.info("document - getDocumentByPurpose");
        List<Document> documentList = documentService.findByPurpose(purpose);
        return new ResponseEntity<>(documentList, HttpStatus.OK);
    }

    //TODO page por parámetro
    @GetMapping
    public ResponseEntity<List<Document>> getDocumentsByUserId(
            @RequestParam("userId") String userId) {
        log.info("document - getAllDocumentsByUserId");
        List<Document> documentList = documentService.findByUserId(userId, PageRequest.of(0, 10, Sort.by(Sort.Direction.DESC, "id")));
        System.out.println(documentList);
        return new ResponseEntity<>(documentList, HttpStatus.OK);
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

    //TODO
    @DeleteMapping("/deleteAllByUserId")
    public ResponseEntity<String> deleteAllByUserId(
            @RequestParam("userId") String userId) {
        log.info("document - deleteAllByUserId");
        documentService.findAllByUserId(userId).forEach(doc -> {
            tagService.deleteByDocumentId(doc.getId());
            fieldService.deleteByDocumentId(doc.getId());
            documentService.deleteByUserId(doc.getId());
        });
        return new ResponseEntity<>("Documents, tags and fields deleted", HttpStatus.OK);
    }

    @DeleteMapping("/deleteByTitle")
    public ResponseEntity<String> deleteAllByTitle(
            @RequestParam("title") String title) {
        log.info("document - deleteByTitle");
        documentService.deleteByTitle(title);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //TODO actual focus
    @RequestMapping( method = RequestMethod.PUT , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateDocumentContent(
            @RequestBody DocumentDTO documentDTO) throws Exception {
        log.info("document - updateDocument");
        documentService.update(documentDTO);

        return new ResponseEntity<>("Content updated: ", HttpStatus.OK);
    }

}
