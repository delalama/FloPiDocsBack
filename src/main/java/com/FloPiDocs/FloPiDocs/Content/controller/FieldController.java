package com.FloPiDocs.FloPiDocs.Content.controller;

import com.FloPiDocs.FloPiDocs.Content.entities.Field;
import com.FloPiDocs.FloPiDocs.Content.service.FieldService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequestMapping("field")
@Controller
public class FieldController {
        protected final Log logger = LogFactory.getLog(getClass());

        @Autowired
        private FieldService fieldService;

        @PostMapping(value = "/createField", produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<Field> createField(
                @RequestParam("documentId") String documentId,
                @RequestParam("fieldName") String fieldName ,
                @RequestParam("fieldValue") String fieldValue ) {
                logger.info("field - createField");

                Field field = new Field(documentId, fieldName, fieldValue);
                Field field1 = fieldService.save(field);
                return new ResponseEntity<Field>( field1 , HttpStatus.OK);
        }

        @GetMapping("/getFieldByDocumentId")
        public ResponseEntity<List<Field>> getFieldByDocumentId(
                @RequestParam("documentId") String documentId) {
                logger.info("Field - getFieldByDocumentId");
                List<Field> fieldList = fieldService.findByDocumentId(documentId);
                return new ResponseEntity<>(fieldList, HttpStatus.OK);
        }

        //TODO
        @DeleteMapping("/deleteAll")
        public ResponseEntity<String> deleteAll() {
                logger.info("Field - deleteAll");
                fieldService.deleteAll();
                return new ResponseEntity<>( HttpStatus.OK);
        }

}
