package com.FloPiDocs.FloPiDocs.Content.controller;

import com.FloPiDocs.FloPiDocs.Content.entities.dto.AccountOptionsDTO;
import com.FloPiDocs.FloPiDocs.Content.service.AccountOptionsService;
import com.FloPiDocs.FloPiDocs.FloPiDocsApplication;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RequestMapping("accountOptions")
@Controller
@Slf4j
public class AccountOptionsController {
        @Autowired
        private AccountOptionsService accountOptionsService;



        @GetMapping("/get")
        public @ResponseBody ResponseEntity<String> get() {
                return new ResponseEntity<>("GET Response", HttpStatus.OK);
        }

        @GetMapping("/get/{id}")
        public @ResponseBody ResponseEntity<String>
        getById(@PathVariable String id) {
                return new ResponseEntity<>("GET Response : "
                        + id, HttpStatus.OK);
        }

        @PostMapping(value = "/createByUserId" ,produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<String> createInitOptions(
                @RequestParam("userId") String userId) {
                log.info("AccountOptions- created initial options");
                AccountOptionsDTO accountOptionsDTO = new AccountOptionsDTO(userId);
                accountOptionsService.save(accountOptionsDTO);
                return new ResponseEntity<>(HttpStatus.OK);
        }

        @PostMapping(value = "/changeSafeDelete" ,produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<String> changeSafeDelete(
                @RequestParam("userId") String userId,
                @RequestParam("safeDelete") boolean safeDelete){
                log.info("AccountOptions- change SafeDelete value");
                accountOptionsService.setSafeDelete(userId, safeDelete);
                return new ResponseEntity<>(HttpStatus.OK);
        }

        @GetMapping(value = "/getAccountOptions" ,produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<AccountOptionsDTO> getAccountOptions(
                @RequestParam("userId") String userId) {
                log.info("AccountOptions- getAccountOptions by ID");
                return new ResponseEntity<>(accountOptionsService.findByUserId(userId),HttpStatus.OK);
        }

        @DeleteMapping(value = "/all" ,produces = MediaType.APPLICATION_JSON_VALUE)
        public void deleteAllAccountOptions() {
                log.info("AccountOptions- Delete All");
                accountOptionsService.deleteAll();
        }

}
