package com.FloPiDocs.FloPiDocs.Content.controller;

import com.FloPiDocs.FloPiDocs.Content.entities.User;
import com.FloPiDocs.FloPiDocs.Content.service.UserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequestMapping("user")
@Controller
public class UserController {

        protected final Log logger = LogFactory.getLog(getClass());

        @Autowired
        private UserService userService;


        @PostMapping("/createUser")
        public ResponseEntity<String> createUser(
                @RequestParam("firstName") String firstName,
                @RequestParam("lastName") String lastName ,
                @RequestParam("email") String email) {
                logger.info("user - createUser");
                if (userService.emailExists(email)){
                        return new ResponseEntity<>("Email already exists: " , HttpStatus.FORBIDDEN);
                }else{
                        userService.createUser(new User(firstName,lastName,email));
                        return new ResponseEntity<>("Added user: " + firstName + " " + lastName + " " + email, HttpStatus.OK);
                }
        }

        @GetMapping("/getAllUsers")
        public ResponseEntity<List<User>> getAllUsers() {
                logger.info("user - getAllUsers");
                List<User> userList = userService.findAll();
                return new ResponseEntity<>(userList, HttpStatus.OK);
        }

        @PostMapping("/updateUser")
        public ResponseEntity<String> updateUser(
                @RequestParam("userId") String userId,
                @RequestParam("firstName") String firstName,
                @RequestParam("lastName") String lastName ,
                @RequestParam("email") String email) {
                logger.info("user - updateUser");
                if (userService.emailExists(email)){
                        return new ResponseEntity<>("Email already exists: " , HttpStatus.FORBIDDEN);
                }else{
                        userService.createUser(new User(firstName,lastName,email));
                        return new ResponseEntity<>("Added user: " + firstName + " " + lastName + " " + email, HttpStatus.OK);
                }
        }
}
