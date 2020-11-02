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

        @PostMapping(value = "/createByUserId" ,produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<String> createInitOptions(
                @RequestParam("userId") String userId) {
                FloPiDocsApplication.logger.info("AccountOptions- created initial options");
                AccountOptionsDTO accountOptionsDTO = new AccountOptionsDTO(userId);

                accountOptionsService.save(accountOptionsDTO);
                return new ResponseEntity<>(HttpStatus.OK);
        }

}
