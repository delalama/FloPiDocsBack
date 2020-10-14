package com.FloPiDocs.FloPiDocs.Content.controller;

import com.FloPiDocs.FloPiDocs.Content.entities.User;
import com.FloPiDocs.FloPiDocs.Content.service.UserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
                //Guille , este booleano lo declararías así? , me gusta mucho escribir así para que el IF, que es lo importante, se lea muy fácil
                boolean FIRSTNAME_EMPTY= firstName=="";
                boolean LASTNAME_EMPTY= lastName=="";

                if( FIRSTNAME_EMPTY){
                        return new ResponseEntity<>("FirstName empty" , HttpStatus.CONFLICT);
                }else if( LASTNAME_EMPTY ){
                        return new ResponseEntity<>("LastName empty" , HttpStatus.CONFLICT);
                }

                boolean EMAIL_EXISTS= userService.emailExists(email);
                boolean EMAIL_INVALID = !EmailValidator.getInstance().isValid(email);

                if ( EMAIL_EXISTS){
                        return new ResponseEntity<>("Email already exists" , HttpStatus.CONFLICT);
                }else if(EMAIL_INVALID){
                        System.out.println(email);
                        return new ResponseEntity<>("Invalid email" , HttpStatus.CONFLICT);
                }else{
                        userService.createUser(new User(firstName,lastName,email));
                        return new ResponseEntity<>("Added user: " + firstName + " " + lastName + " " + email, HttpStatus.OK);
                }
        }

        @GetMapping(value = "/getAllUsers", produces = MediaType.APPLICATION_JSON_VALUE)
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


        @GetMapping("/deleteAllUsers")
        public ResponseEntity<String> deleteAllUsers() {
                logger.info("user - deleteAllUsers");
                userService.deleteAll();
                return new ResponseEntity<>("Users deleted", HttpStatus.OK);
        }
}
