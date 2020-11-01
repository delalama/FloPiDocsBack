package com.FloPiDocs.FloPiDocs.Content.controller;

import com.FloPiDocs.FloPiDocs.Content.entities.dto.UserDTO;
import io.jsonwebtoken.Jwts;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

//@RequestMapping("token")
@RestController
public class TokenController {

        @PostMapping("token")
        public UserDTO login(@RequestParam("email") String email, @RequestParam("password") String pwd) {
            UserDTO user = new UserDTO();
            user.setEmail(email);
            return user;
        }

    }
