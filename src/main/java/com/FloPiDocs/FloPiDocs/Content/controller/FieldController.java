package com.FloPiDocs.FloPiDocs.Content.controller;

import com.FloPiDocs.FloPiDocs.Content.entities.Field;
import com.FloPiDocs.FloPiDocs.Content.entities.dto.FieldDTO;
import com.FloPiDocs.FloPiDocs.Content.service.FieldService;
import com.FloPiDocs.FloPiDocs.FloPiDocsApplication;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SuppressWarnings("rawtypes")
@CrossOrigin
@RequestMapping("fields")
@Controller
public class FieldController {

        @Autowired
        private FieldService fieldService;

        @Autowired
        ModelMapper modelMapper = new ModelMapper();

        @RequestMapping(method = RequestMethod.PUT, produces = "application/json", consumes = "application/json")
        public ResponseEntity createField(
                @RequestBody FieldDTO fieldDTO) {
                FloPiDocsApplication.logger.info("field - createField");

                return fieldService.save(fieldDTO);
        }

/*              TODO BORRAR CUANDO FUNCIONE "CREATEFIELD"
        @PostMapping(value = "/createField", produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<Field> createFieldOld(
                @RequestParam("documentId") String documentId,
                @RequestParam("fieldName") String fieldName ,
                @RequestParam("fieldValue") String fieldValue ) {
                FloPiDocsApplication.logger.info("field - createField");

                Field field = new Field(documentId, fieldName, fieldValue);
                Field field1 = fieldService.save(field);
                return new ResponseEntity<Field>( field1 , HttpStatus.OK);
        }
*/

        @GetMapping("/getFieldByDocumentId")
        public ResponseEntity<List<Field>> getFieldByDocumentId(
                @RequestParam("documentId") String documentId) {
                FloPiDocsApplication.logger.info("Field - getFieldByDocumentId");
                List<Field> fieldList = fieldService.findByDocumentId(documentId);
                return new ResponseEntity<>(fieldList, HttpStatus.OK);
        }

        @PostMapping ("/deleteFieldById")
        public ResponseEntity<FieldDTO> deleteFieldById(
                @RequestParam("fieldId") String fieldId) {
                FloPiDocsApplication.logger.info("Field - deleteFieldById");
                FieldDTO fieldDTO = fieldService.deleteById(fieldId);
                return new ResponseEntity<>(fieldDTO, HttpStatus.OK);
        }

        @DeleteMapping("/deleteAll")
        public ResponseEntity<String> deleteAll() {
                FloPiDocsApplication.logger.info("Field - deleteAll");
                fieldService.deleteAll();
                return new ResponseEntity<>( HttpStatus.OK);
        }

}
