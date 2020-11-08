package com.FloPiDocs.FloPiDocs.Content.controller;

import com.FloPiDocs.FloPiDocs.Content.entities.AccountOptions;
import com.FloPiDocs.FloPiDocs.Content.entities.Field;
import com.FloPiDocs.FloPiDocs.Content.entities.User;
import com.FloPiDocs.FloPiDocs.Content.entities.dto.AccountOptionsDTO;
import com.FloPiDocs.FloPiDocs.Content.service.AccountOptionsService;
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
@RequestMapping("accountOptions")
@Controller
public class AccountOptionsController {

        @Autowired
        ModelMapper modelMapper = new ModelMapper();

        @Autowired
        private AccountOptionsService accountOptionsService;






        @GetMapping("/get")
        public @ResponseBody ResponseEntity<String> get() {
                return new ResponseEntity<String>("GET Response", HttpStatus.OK);
        }

        @GetMapping("/get/{id}")
        public @ResponseBody ResponseEntity<String>
        getById(@PathVariable String id) {
                return new ResponseEntity<String>("GET Response : "
                        + id, HttpStatus.OK);
        }

        @PostMapping("/post")
        public @ResponseBody ResponseEntity<String> post() {
                return new ResponseEntity<String>("POST Response", HttpStatus.OK);
        }

        @PutMapping("/put")
        public @ResponseBody ResponseEntity<String> put() {
                return new ResponseEntity<String>("PUT Response", HttpStatus.OK);
        }

        @DeleteMapping("/delete")
        public @ResponseBody ResponseEntity<String> delete() {
                return new ResponseEntity<String>("DELETE Response", HttpStatus.OK);
        }





















        @PostMapping(value = "/createByUserId" ,produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<String> createInitOptions(
                @RequestParam("userId") String userId) {
                FloPiDocsApplication.logger.info("AccountOptions- created initial options");
                AccountOptionsDTO accountOptionsDTO = new AccountOptionsDTO(userId);
                accountOptionsService.save(accountOptionsDTO);
                return new ResponseEntity<>(HttpStatus.OK);
        }

        @PostMapping(value = "/changeSafeDelete" ,produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<String> changeSafeDelete(
                @RequestParam("userId") String userId,
                @RequestParam("safeDelete") boolean safeDelete){
                FloPiDocsApplication.logger.info("AccountOptions- change SafeDelete value");
                accountOptionsService.setSafeDelete(userId, safeDelete);
                return new ResponseEntity<>(HttpStatus.OK);
        }

        @GetMapping(value = "/getAccountOptions" ,produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<AccountOptionsDTO> getAccountOptions(
                @RequestParam("userId") String userId) {
                FloPiDocsApplication.logger.info("AccountOptions- getAccountOptions by ID");
                return new ResponseEntity<>(accountOptionsService.findByUserId(userId),HttpStatus.OK);
        }

}
