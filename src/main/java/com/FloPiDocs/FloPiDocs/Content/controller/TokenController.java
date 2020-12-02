package com.FloPiDocs.FloPiDocs.Content.controller;

import com.FloPiDocs.FloPiDocs.Content.model.dto.UserDTO;
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
        public UserDTO login(@RequestParam("email") String email, @RequestParam("password") String pwd) {
            UserDTO user = new UserDTO();
            user.setEmail(email);
            return user;
        }

    }
