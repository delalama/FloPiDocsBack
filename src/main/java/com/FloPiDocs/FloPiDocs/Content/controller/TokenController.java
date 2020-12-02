package com.FloPiDocs.FloPiDocs.Content.controller;

import com.FloPiDocs.FloPiDocs.Content.model.dto.UserDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TokenController {

        @PostMapping("token")
        public UserDTO login(@RequestParam("email") String email, @RequestParam("password") String pwd) {
            UserDTO user = new UserDTO();
            user.setEmail(email);
            return user;
        }

    }
