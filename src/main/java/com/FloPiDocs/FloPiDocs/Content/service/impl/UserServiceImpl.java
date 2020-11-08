package com.FloPiDocs.FloPiDocs.Content.service.impl;

import com.FloPiDocs.FloPiDocs.Content.entities.dto.AccountOptionsDTO;
import com.FloPiDocs.FloPiDocs.Content.entities.dto.UserDTO;
import com.FloPiDocs.FloPiDocs.Content.repository.UserRepository;
import com.FloPiDocs.FloPiDocs.Content.entities.User;
import com.FloPiDocs.FloPiDocs.Content.service.AccountOptionsService;
import com.FloPiDocs.FloPiDocs.Content.service.DocumentService;
import com.FloPiDocs.FloPiDocs.Content.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    ModelMapper modelMapper = new ModelMapper();
    @Autowired
    UserRepository userRepository;
    @Autowired
    private DocumentService documentService;
    @Autowired
    private AccountOptionsService accountOptionsService;
    @Override
    public ResponseEntity<UserDTO> createUser(UserDTO userDTO) {

        boolean EMAIL_EXISTS = emailAlreadyExists(userDTO.getEmail());

        if (EMAIL_EXISTS) {
            return new ResponseEntity("EMAIL ALREADY EXISTS", HttpStatus.CONFLICT);
        } else {
            // Create user
            User userCreated = userRepository.save( modelMapper.map(userDTO, User.class) );

            UserDTO userCreatedDto = modelMapper.map(userCreated, UserDTO.class);

            // Create new user AccountOptions
            accountOptionsService.save(new AccountOptionsDTO(userCreatedDto.getUserId()));

            return new ResponseEntity<>(userCreatedDto, HttpStatus.OK);
        }
    }

    @Override
    public Boolean emailAlreadyExists(String email){
        Optional<User> userList = userRepository.findByEmail(email);

        return !userList.isEmpty();
    }

    @Override
    public void deleteAll() {
        userRepository.deleteAll();
    }

    public UserDTO findByEmail(String email) {
        return modelMapper.map(userRepository.findByEmail(email).get(), UserDTO.class);
    }

    @Override
    public User findByUserId(String id) {
        return userRepository.findByUserId(id);
    }

    @Override
    public void deleteUser(String id) { }

    @Override
    public List<User> findAll() {
//        ModelMapper modelMapper = new ModelMapper();
// user here is a prepopulated User instance
//        List<UserDTO> userDTO = modelMapper.map(userRepository.findAll(), UserDTO.class);
        return userRepository.findAll();
    }

    @Override
    public long count() {
        return userRepository.count();
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }
}
