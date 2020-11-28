package com.FloPiDocs.FloPiDocs.Content.controller;

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

        @RequestMapping(method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
        public ResponseEntity createField(
                @RequestBody FieldDTO fieldDTO) {
                log.info("field - createField");
                return fieldService.save(fieldDTO);
        }

        @RequestMapping(method = RequestMethod.PUT, produces = "application/json", consumes = "application/json")
        public ResponseEntity<FieldDTO> updateField(
                @RequestBody FieldDTO fieldDTO) {
                log.info("field - updateField");
                return new ResponseEntity<FieldDTO>(fieldService.update(fieldDTO), HttpStatus.OK) ;
        }

        @GetMapping("/getFieldByDocumentId")
        public ResponseEntity<List<FieldDTO>> getFieldByDocumentId(
                @RequestParam("documentId") String documentId) {
                log.info("Field - getFieldByDocumentId");
                return new ResponseEntity<>(fieldService.findByDocumentId(documentId), HttpStatus.OK);
        }

        @PostMapping ("/deleteFieldById")
        public ResponseEntity<FieldDTO> deleteFieldById(
                @RequestParam("fieldId") String fieldId) {
                log.info("Field - deleteFieldById");
                return new ResponseEntity<>(fieldService.deleteById(fieldId), HttpStatus.OK);
        }

        @DeleteMapping("/deleteAll")
        public ResponseEntity<String> deleteAll() {
                log.info("Field - deleteAll");
                fieldService.deleteAll();
                return new ResponseEntity<>( HttpStatus.OK);
        }

}
