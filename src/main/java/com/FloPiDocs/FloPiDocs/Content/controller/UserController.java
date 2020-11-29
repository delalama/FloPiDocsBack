package com.FloPiDocs.FloPiDocs.Content.controller;

import com.FloPiDocs.FloPiDocs.Content.controller.utils.MailAndPass;
import com.FloPiDocs.FloPiDocs.Content.model.persistence.User;
import com.FloPiDocs.FloPiDocs.Content.model.dto.UserDTO;
import com.FloPiDocs.FloPiDocs.Content.service.DocumentService;
import com.FloPiDocs.FloPiDocs.Content.service.UserService;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("users")
@RestController
@Slf4j
@AllArgsConstructor
public class UserController {

    private final UserService userService;
    private final DocumentService documentService;

    @PostMapping("login")
    @ResponseBody
    public UserDTO login(
            @RequestBody MailAndPass mailAndPass) throws Exception {
        log.info("user - login");
        return userService.login(mailAndPass);
    }

    //TODO ENCRIPTAR PASSWORD AL PASAR A PRODUCCIÓN
    @RequestMapping(method = RequestMethod.PUT, produces = "application/json", consumes = "application/json")
    @JsonIgnoreProperties(value = {"userId", "token"})
    public ResponseEntity createUser(
            @RequestBody UserDTO userDTO) throws Exception {
        log.info("user - createUser");
        return userService.createUser(userDTO);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.OK)
    public void deleteUserById(
            @RequestParam String userId) {
        userService.deleteUser(userId);
    }

    @RequestMapping(value = "emailAlreadyExists", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public Boolean emailNotAvailable(
            @RequestBody String email) throws Exception {
        log.info("user - createUser");
        return userService.emailAlreadyExists(email);
    }

    /**
     * Manager method
     *
     * @return ResponseEntity
     */
    @RequestMapping(value = "all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        log.info("user - getAllUsers");

        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/updateUser")
    public ResponseEntity<String> updateUser(
            @RequestParam("userId") String userId,
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName) {
        log.info("user - updateUser");
        User userToUpdate = userService.findByUserId(userId);
        userService.save(new User(userId, firstName, lastName, userToUpdate.getEmail()));
        return new ResponseEntity<>("User updated", HttpStatus.OK);
    }

    @DeleteMapping("/deleteAllUsers")
    public ResponseEntity<String> deleteAllUsers() {
        log.info("user - deleteAllUsers");
        userService.deleteAll();
        return new ResponseEntity<>("Users deleted", HttpStatus.OK);
    }

    //dev method, must be deleted
    @DeleteMapping("/deleteAllContent")
    public ResponseEntity<String> deleteAllContent() {
        log.info("user - deleteAllContent");
        userService.deleteAllContent();
        return new ResponseEntity<>("All content deleted", HttpStatus.OK);
    }

    @PostMapping("/updateUserEmail")
    public ResponseEntity<String> updateUserEmail(
            @RequestParam("userId") String userId,
            @RequestParam("email") String email) {
        log.info("user - updateUser");
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

}
