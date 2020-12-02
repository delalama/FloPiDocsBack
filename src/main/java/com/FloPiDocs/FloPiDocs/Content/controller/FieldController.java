package com.FloPiDocs.FloPiDocs.Content.controller;

import com.FloPiDocs.FloPiDocs.Content.model.dto.FieldDTO;
import com.FloPiDocs.FloPiDocs.Content.service.FieldService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The type Field controller.
 */
@CrossOrigin
@RequestMapping("field")
@Controller
@Slf4j
public class FieldController {

        @Autowired
        private FieldService fieldService;

        /**
         * Create field
         *
         * @param fieldDTO the field dto
         * @return created Field
         */
        @RequestMapping(method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
        public ResponseEntity<FieldDTO> createField(
                @RequestBody FieldDTO fieldDTO) {
                log.info("field - createField");
                return new ResponseEntity<>(fieldService.save(fieldDTO), HttpStatus.OK);
        }

        /**
         * Update field data
         *
         * @param fieldDTO the field dto
         * @return updated FieldDto
         */
        @RequestMapping(method = RequestMethod.PUT, produces = "application/json", consumes = "application/json")
        public ResponseEntity<FieldDTO> updateField(
                @RequestBody FieldDTO fieldDTO) {
                log.info("field - updateField");
                return new ResponseEntity<>(fieldService.update(fieldDTO), HttpStatus.OK) ;
        }

        /**
         * Get fields by documentId
         *
         * @param documentId the document id
         * @return List<FieldDto> field by document id
         */
        @GetMapping("/getFieldByDocumentId")
        public ResponseEntity<List<FieldDTO>> getFieldByDocumentId(
                @RequestParam("documentId") String documentId) {
                log.info("Field - getFieldByDocumentId");
                return new ResponseEntity<>(fieldService.findByDocumentId(documentId), HttpStatus.OK);
        }

        /**
         * Delete field by fieldId
         *
         * @param fieldId the field id
         * @return fieldDto response entity
         */
        @PostMapping ("/deleteFieldById")
        public ResponseEntity<FieldDTO> deleteFieldById(
                @RequestParam("fieldId") String fieldId) {
                log.info("Field - deleteFieldById");
                return new ResponseEntity<>(fieldService.deleteById(fieldId), HttpStatus.OK);
        }

        /**
         * Manager method
         * Delete all fields
         *
         * @return response entity
         */
        @DeleteMapping("/deleteAll")
        public ResponseEntity<String> deleteAll() {
                log.info("Field - deleteAll");
                fieldService.deleteAll();
                return new ResponseEntity<>( HttpStatus.OK);
        }

}
