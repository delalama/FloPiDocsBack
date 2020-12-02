package com.FloPiDocs.FloPiDocs.Content.controller;

import com.FloPiDocs.FloPiDocs.Content.model.dto.AccountOptionsDTO;
import com.FloPiDocs.FloPiDocs.Content.service.AccountOptionsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RequestMapping("accountOption")
@Controller
@Slf4j
public class AccountOptionsController {
        @Autowired
        private AccountOptionsService accountOptionsService;


        /**
        * Returns the options of the user account
        * @Param userId
        * @return requested account options
         */
        @GetMapping
        public ResponseEntity<AccountOptionsDTO> getAccountOptions(
                @RequestParam("userId") String userId) {
                log.info("AccountOptions- getAccountOptions by ID");
                return new ResponseEntity<>(accountOptionsService.findByUserId(userId),HttpStatus.OK);
        }

        /**
         * Create new user
         * @param userId
         * @return httpStatus
         */
        @PostMapping(value = "/createByUserId" ,produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<String> createInitOptions(
                @RequestParam("userId") String userId) {
                log.info("AccountOptions- created initial options");
                accountOptionsService.save(new AccountOptionsDTO(userId));
                return new ResponseEntity<>(HttpStatus.OK);
        }

        /**
         * Change safe delete option
         * @param userId
         * @param safeDelete
         * @return HttpStatus
         */
        @PostMapping(value = "/changeSafeDelete" ,produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<String> changeSafeDelete(
                @RequestParam("userId") String userId,
                @RequestParam("safeDelete") boolean safeDelete){
                log.info("AccountOptions- change SafeDelete value");
                accountOptionsService.setSafeDelete(userId, safeDelete);
                return new ResponseEntity<>(HttpStatus.OK);
        }

        /**
         * Manager method
         * @return
         */
        @DeleteMapping(value = "/all" ,produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<String> deleteAllAccountOptions() {
                log.info("AccountOptions- Delete All");
                accountOptionsService.deleteAll();
                return new ResponseEntity<>(HttpStatus.OK);
        }

}
