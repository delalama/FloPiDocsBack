package com.FloPiDocs.FloPiDocs.Content.controller;

import com.FloPiDocs.FloPiDocs.Content.model.persistence.Field;
import com.FloPiDocs.FloPiDocs.Content.model.dto.FieldDTO;
import com.FloPiDocs.FloPiDocs.Content.service.FieldService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SuppressWarnings("rawtypes")
@CrossOrigin
@RequestMapping("field")
@Controller
@Slf4j
public class FieldController {

        @Autowired
        private FieldService fieldService;

        ModelMapper modelMapper = new ModelMapper();

        @RequestMapping(method = RequestMethod.PUT, produces = "application/json", consumes = "application/json")
        public ResponseEntity createField(
                @RequestBody FieldDTO fieldDTO) {
                log.info("field - createField");

                return fieldService.save(fieldDTO);
        }

        @GetMapping("/getFieldByDocumentId")
        public ResponseEntity<List<Field>> getFieldByDocumentId(
                @RequestParam("documentId") String documentId) {
                log.info("Field - getFieldByDocumentId");
                List<Field> fieldList = fieldService.findByDocumentId(documentId);
                return new ResponseEntity<>(fieldList, HttpStatus.OK);
        }

        @PostMapping ("/deleteFieldById")
        public ResponseEntity<FieldDTO> deleteFieldById(
                @RequestParam("fieldId") String fieldId) {
                log.info("Field - deleteFieldById");
                FieldDTO fieldDTO = fieldService.deleteById(fieldId);
                return new ResponseEntity<>(fieldDTO, HttpStatus.OK);
        }

        @DeleteMapping("/deleteAll")
        public ResponseEntity<String> deleteAll() {
                log.info("Field - deleteAll");
                fieldService.deleteAll();
                return new ResponseEntity<>( HttpStatus.OK);
        }

}
