package com.FloPiDocs.FloPiDocs.Content.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Token controller.
 */
@RestController
public class TokenController {

    /**
     * Login user dto.
     *
     * @param email the email
     * @param pwd   the pwd
     * @return the user dto
     */
    @PostMapping("token")
        public com.FloPiDocs.FloPiDocs.Content.model.dto.UserDto login(@RequestParam("email") String email, @RequestParam("password") String pwd) {
            com.FloPiDocs.FloPiDocs.Content.model.dto.UserDto user = new com.FloPiDocs.FloPiDocs.Content.model.dto.UserDto();
            user.setEmail(email);
            return user;
        }

    }
