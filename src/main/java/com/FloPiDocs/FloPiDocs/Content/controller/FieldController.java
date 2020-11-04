package com.FloPiDocs.FloPiDocs.Content.controller;

import com.FloPiDocs.FloPiDocs.Content.entities.Field;
import com.FloPiDocs.FloPiDocs.Content.entities.dto.FieldDTO;
import com.FloPiDocs.FloPiDocs.Content.service.FieldService;
import com.FloPiDocs.FloPiDocs.FloPiDocsApplication;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.modelmapper.ModelMapper;
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

        @Autowired
        private FieldService fieldService;

        @Autowired
        ModelMapper modelMapper = new ModelMapper();

        @PostMapping(value = "/createField", produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<Field> createField(
                @RequestParam("documentId") String documentId,
                @RequestParam("fieldName") String fieldName ,
                @RequestParam("fieldValue") String fieldValue ) {
                FloPiDocsApplication.logger.info("field - createField");

                Field field = new Field(documentId, fieldName, fieldValue);
                Field field1 = fieldService.save(field);
                return new ResponseEntity<Field>( field1 , HttpStatus.OK);
        }

        @GetMapping("/getFieldByDocumentId")
        public ResponseEntity<List<Field>> getFieldByDocumentId(
                @RequestParam("documentId") String documentId) {
                FloPiDocsApplication.logger.info("Field - getFieldByDocumentId");
                List<Field> fieldList = fieldService.findByDocumentId(documentId);
                return new ResponseEntity<>(fieldList, HttpStatus.OK);
        }

        @PostMapping ("/deleteFieldById")
        public ResponseEntity<FieldDTO> deleteFieldById(
                @RequestParam("fieldId") String documentId) {
                FloPiDocsApplication.logger.info("Field - deleteFieldById");
                FieldDTO fieldDTO = fieldService.deleteById(documentId);
                return new ResponseEntity<>(fieldDTO, HttpStatus.OK);
        }

        @DeleteMapping("/deleteAll")
        public ResponseEntity<String> deleteAll() {
                FloPiDocsApplication.logger.info("Field - deleteAll");
                fieldService.deleteAll();
                return new ResponseEntity<>( HttpStatus.OK);
        }

}
