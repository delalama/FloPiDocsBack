package com.FloPiDocs.FloPiDocs.Content.controller;

import com.FloPiDocs.FloPiDocs.Content.entities.Document;
import com.FloPiDocs.FloPiDocs.Content.service.DocumentService;
import com.FloPiDocs.FloPiDocs.Content.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.Calendar;
import java.util.List;

@RequestMapping("document")
@Controller
public class DocumentController {
        protected final Log logger = LogFactory.getLog(getClass());

        @Autowired
        private DocumentService documentService;
        @Autowired
        private UserService userService;

        //TODO cómo hacer que pete el controlador cuando le pasas más parámetros de los esperados?
        @PostMapping(value = "/createDocument", produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<String> createDocument(
                @RequestParam("userId") String userId,
                @RequestParam("title") String title ,
                @RequestParam("purpose") String purpose) {
                logger.info("document - createDocument");
                if( userId == ""){
                        return new ResponseEntity<>("Empty userId", HttpStatus.CONFLICT);
                }else if( title == ""){
                        return new ResponseEntity<>("Empty title", HttpStatus.CONFLICT);
                }else if( purpose == ""){
                        return new ResponseEntity<>("Empty purpose", HttpStatus.CONFLICT);
                }
                Document document = new Document(userId, title, purpose, Calendar.getInstance().getTime().toString());
                documentService.createDocument(document);
                return new ResponseEntity<>("Added Document: " + title, HttpStatus.OK);
        }


        @GetMapping("/getDocumentByTitle")
        public ResponseEntity<List<Document>> getDocumentByTitle(
                @RequestParam("title") String title) {
                logger.info("document - getDocumentByTitle");
                List<Document> documentList = documentService.findByTitle(title);
                return new ResponseEntity<>(documentList, HttpStatus.OK);
        }

        @GetMapping("/getDocumentByPurpose")
        public ResponseEntity<List<Document>> getDocumentByPurpose (
                @RequestParam("purpose") String purpose) {
                        logger.info("document - getDocumentByPurpose");
                List<Document> documentList = documentService.findByPurpose(purpose);
                return new ResponseEntity<>(documentList, HttpStatus.OK);
        }

        @GetMapping("/getAllDocumentsByUserId")
        public ResponseEntity<List<Document>> getDocumentsByUserId(
                @RequestParam("userId") String userId) {
                logger.info("document - getAllDocumentsByUserId");
                List<Document> documentList = documentService.findByUserId(userId);
                System.out.println(documentList);
                return new ResponseEntity<>(documentList, HttpStatus.OK);
        }

        //TODO
        @DeleteMapping("/deleteAll")
        public ResponseEntity<String> deleteAll() {
                logger.info("document - deleteAll");
                documentService.deleteAll();
                return new ResponseEntity<>( HttpStatus.OK);
        }

        //TODO
        @DeleteMapping("/deleteAllByUserId")
        public ResponseEntity<String> deleteAllByUserId(
                @RequestParam("userId") String userId) {
                logger.info("document - deleteAllByUserId");
                documentService.deleteByUserId(userId);
                return new ResponseEntity<>( HttpStatus.OK);
        }

        @DeleteMapping("/deleteByTitle")
        public ResponseEntity<String> deleteAllByTitle(
                @RequestParam("title") String title) {
                logger.info("document - deleteByTitle");
                documentService.deleteByTitle(title);
                return new ResponseEntity<>( HttpStatus.OK);
        }

        //TODO actual focus
        @PostMapping(value = "/updateDocumentContent", produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<String> updateDocumentContent(
                @RequestParam("documentId") String userId,
                @RequestParam("content") String content) {
                logger.info("document - updateDocumentContent");
                List<Document> doc = documentService.findByUserId(userId);
                Document doc2 = doc.get(0);
                Document document = new Document(doc2.getId(), userId,doc2.getTitle(), doc2.getPurpose(), doc2.getDate(), content );
                documentService.save(document);
                return new ResponseEntity<>("Content updated: " , HttpStatus.OK);
        }

}
