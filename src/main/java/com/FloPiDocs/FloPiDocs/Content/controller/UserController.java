package com.FloPiDocs.FloPiDocs.Content.controller;

import com.FloPiDocs.FloPiDocs.Content.entities.User;
import com.FloPiDocs.FloPiDocs.Content.entities.dto.AccountOptionsDTO;
import com.FloPiDocs.FloPiDocs.Content.entities.dto.UserDTO;
import com.FloPiDocs.FloPiDocs.Content.service.AccountOptionsService;
import com.FloPiDocs.FloPiDocs.Content.service.DocumentService;
import com.FloPiDocs.FloPiDocs.Content.service.UserService;
import com.FloPiDocs.FloPiDocs.FloPiDocsApplication;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.validator.routines.EmailValidator;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("user")
@RestController
public class UserController {
        @Autowired
        private UserService userService;
        @Autowired
        private DocumentService documentService;
        @Autowired
        private AccountOptionsService accountOptionsService;
        @Autowired
        ModelMapper modelMapper = new ModelMapper();

        @GetMapping(value = "login", produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<UserDTO> login(
                @RequestParam("email") String email,
                @RequestParam("password") String password)  {
                FloPiDocsApplication.logger.info("user - login");
                Optional<UserDTO> user = Optional.ofNullable(userService.findByEmail(email));
                if(user.isPresent() && user.get().getPassWord().equals(password)){
                        return new ResponseEntity<UserDTO>(user.get(), HttpStatus.OK);
                }else{
                        return new ResponseEntity<UserDTO>(new UserDTO(), HttpStatus.CONFLICT);
                }
        }

//        convención RESTFUL
//                se hacen las peticiones a "user", dependiendo de la acción es un GET, POST....
        @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<List<User>> getUsers(
                @RequestParam("email") String email,
                @RequestParam("password") String password) {
                FloPiDocsApplication.logger.info("user - getAllUsers");
                List<User> userList = userService.findAll();
                return new ResponseEntity<>(userList, HttpStatus.OK);
        }


        @CrossOrigin
        @PostMapping("/createUser")
        public ResponseEntity<UserDTO> createUser(
                @RequestParam("password") String password,
                @RequestParam("firstName") String firstName,
                @RequestParam("lastName") String lastName ,
                @RequestParam("email") String email) {
                FloPiDocsApplication.logger.info("user - createUser");

                boolean FIRSTNAME_EMPTY = firstName=="";
                boolean LASTNAME_EMPTY = lastName=="";

                //TODO ENCRIPTAR PASSWORD
                if( FIRSTNAME_EMPTY){
                        return new ResponseEntity<UserDTO>(new UserDTO() , HttpStatus.CONFLICT);
                }else if( LASTNAME_EMPTY ){
                        return new ResponseEntity<UserDTO>(new UserDTO() , HttpStatus.CONFLICT);
                }

                boolean EMAIL_EXISTS= userService.emailExists(email);
                boolean EMAIL_INVALID = !EmailValidator.getInstance().isValid(email);

                if ( EMAIL_EXISTS){
                        return new ResponseEntity<UserDTO>(new UserDTO() , HttpStatus.CONFLICT);
                }else if(EMAIL_INVALID){
                        System.out.println(email);
                        return new ResponseEntity<UserDTO>(new UserDTO() , HttpStatus.CONFLICT);
                }else{
                        // Create user
                        UserDTO userCreated = userService.createUser(new UserDTO(firstName,lastName,email, password));

                        //create new user AccountOptions
                        AccountOptionsDTO accountOptionsDTO = new AccountOptionsDTO(userCreated.getUserId());
                        accountOptionsService.save(accountOptionsDTO);

                        return new ResponseEntity<UserDTO>( userCreated, HttpStatus.OK);
                }
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
                if(userToUpdate==null){
                        return new ResponseEntity<>("No user found", HttpStatus.CONFLICT);
                }
                else if(email.equals(userToUpdate.getEmail())){
                        return new ResponseEntity<>("Email exists", HttpStatus.CONFLICT);
                }else if(StringUtils.isEmpty(email)){
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
                userList.forEach( t -> {
                        documentService.deleteAllByUserId(t.getUserId());

                } );
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
