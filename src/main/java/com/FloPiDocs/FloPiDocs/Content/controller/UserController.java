package com.FloPiDocs.FloPiDocs.Content.controller;

import com.FloPiDocs.FloPiDocs.Content.entities.User;
import com.FloPiDocs.FloPiDocs.Content.entities.dto.UserDTO;
import com.FloPiDocs.FloPiDocs.Content.service.DocumentService;
import com.FloPiDocs.FloPiDocs.Content.service.UserService;
import com.FloPiDocs.FloPiDocs.FloPiDocsApplication;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("users")
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    ModelMapper modelMapper = new ModelMapper();

    // a la capa service durante el refactor
    @Autowired
    private DocumentService documentService;

    @Getter
    @Setter
    @AllArgsConstructor
    public static class MailAndPass {
        private String email;
        private String password;
    }

    @RequestMapping(
            value = "whatever",
            method = RequestMethod.PUT,
            produces = "application/json",
            consumes = "application/json")
    @ResponseBody
    public ResponseEntity<User> postController(
            @RequestBody User user) {
        User user1 = new User(user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassWord());
        return new ResponseEntity<>(user1, HttpStatus.OK);
    }


    @RequestMapping(
            value = "login", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    @ResponseBody
    public ResponseEntity<UserDTO> login(
            @RequestBody MailAndPass mailAndPass) {
        FloPiDocsApplication.logger.info("user - login");
        Optional<UserDTO> user = Optional.ofNullable(userService.findByEmail(mailAndPass.getEmail()));
        if (user.isPresent() && user.get().getPassword().equals(mailAndPass.getPassword())) {
            return new ResponseEntity<UserDTO>(user.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<UserDTO>(new UserDTO(), HttpStatus.CONFLICT);
        }
    }

    //TODO ENCRIPTAR PASSWORD AL PASAR A PRODUCCIÓN
    @RequestMapping(method = RequestMethod.PUT, produces = "application/json", consumes = "application/json")
    @JsonIgnoreProperties(value = {"userId", "token"})
    public ResponseEntity<UserDTO> createUser(
            @RequestBody UserDTO userDTO) {
        FloPiDocsApplication.logger.info("user - createUser");

        return userService.createUser(userDTO);
    }

    @RequestMapping(value = "emailAlreadyExists" , method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public Boolean emailNotAvailable(
            @RequestBody String email) {
        FloPiDocsApplication.logger.info("user - createUser");

        return userService.emailAlreadyExists(email) ;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<User>> getUsers(
            @RequestParam("email") String email,
            @RequestParam("password") String password) {
        FloPiDocsApplication.logger.info("user - getAllUsers");
        List<User> userList = userService.findAll();
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }


    @GetMapping(value = "/getAllUsers", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<User>> getAllUsers() {
        FloPiDocsApplication.logger.info("user - getAllUsers");
        List<User> userList = userService.findAll();
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }


    //TODO VALORES EMPTY
    @PostMapping("/updateUser")
    public ResponseEntity<String> updateUser(
            @RequestParam("userId") String userId,
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName) {
        FloPiDocsApplication.logger.info("user - updateUser");
        User userToUpdate = userService.findByUserId(userId);
        userService.save(new User(userId, firstName, lastName, userToUpdate.getEmail()));
        return new ResponseEntity<>("User updated", HttpStatus.OK);
    }

    //TODO email EMPTY, Guille algo habrá para que el controlador no acepte valores empty
    @PostMapping("/updateUserEmail")
    public ResponseEntity<String> updateUserEmail(
            @RequestParam("userId") String userId,
            @RequestParam("email") String email) {
        FloPiDocsApplication.logger.info("user - updateUser");
        User userToUpdate = userService.findByUserId(userId);
        if (userToUpdate == null) {
            return new ResponseEntity<>("No user found", HttpStatus.CONFLICT);
        } else if (email.equals(userToUpdate.getEmail())) {
            return new ResponseEntity<>("Email exists", HttpStatus.CONFLICT);
        } else if (StringUtils.isEmpty(email)) {
            return new ResponseEntity<>("Empty email", HttpStatus.CONFLICT);
        }
        userService.save(new User(userId, userToUpdate.getFirstName(), userToUpdate.getLastName(), email));
        return new ResponseEntity<>("Email updated", HttpStatus.OK);
    }

    @DeleteMapping("/deleteAllUsers")
    public ResponseEntity<String> deleteAllUsers() {
        FloPiDocsApplication.logger.info("user - deleteAllUsers");
        userService.deleteAll();
        return new ResponseEntity<>("Users deleted", HttpStatus.OK);
    }

    //dev method, must be deleted
    @DeleteMapping("/deleteAllContent")
    public ResponseEntity<String> deleteAllContent() {
        FloPiDocsApplication.logger.info("user - deleteAllContent");
        List<User> userList = userService.findAll();
        userList.forEach(t -> {
            documentService.deleteAllByUserId(t.getUserId());

        });
        userService.deleteAll();

        return new ResponseEntity<>("All content deted", HttpStatus.OK);
    }

    @DeleteMapping("/deleteUsersById")
    public ResponseEntity<String> deleteUserById() {
        FloPiDocsApplication.logger.info("user - deleteUserById");
        userService.deleteAll();
        return new ResponseEntity<>("Users deleted", HttpStatus.OK);
    }


}
