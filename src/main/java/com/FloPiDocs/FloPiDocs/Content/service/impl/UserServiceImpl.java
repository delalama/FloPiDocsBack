package com.FloPiDocs.FloPiDocs.Content.service.impl;

import com.FloPiDocs.FloPiDocs.Content.controller.UserController;
import com.FloPiDocs.FloPiDocs.Content.controller.utils.MailAndPass;
import com.FloPiDocs.FloPiDocs.Content.entities.dto.AccountOptionsDTO;
import com.FloPiDocs.FloPiDocs.Content.entities.dto.UserDTO;
import com.FloPiDocs.FloPiDocs.Content.repository.UserRepository;
import com.FloPiDocs.FloPiDocs.Content.entities.User;
import com.FloPiDocs.FloPiDocs.Content.service.AccountOptionsService;
import com.FloPiDocs.FloPiDocs.Content.service.DocumentService;
import com.FloPiDocs.FloPiDocs.Content.service.UserService;
import com.FloPiDocs.FloPiDocs.FloPiDocsApplication;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.stream.Collectors;
import java.util.List;
import java.util.Optional;

@SuppressWarnings("unchecked")
@Service
public class UserServiceImpl implements UserService {
    ModelMapper modelMapper = new ModelMapper();
    @Autowired
    UserRepository userRepository;
    @Autowired
    private DocumentService documentService;
    @Autowired
    private AccountOptionsService accountOptionsService;

    @Override
    public ResponseEntity createUser(UserDTO userDTO) {
            // Create user
            User userCreated = userRepository.save( modelMapper.map(userDTO, User.class) );

            UserDTO userCreatedDto = modelMapper.map(userCreated, UserDTO.class);

            // Create new user AccountOptions
            accountOptionsService.save(new AccountOptionsDTO(userCreatedDto.getUserId()));

            return new ResponseEntity<>(userCreatedDto, HttpStatus.OK);
    }

    @Override
    public Boolean emailAlreadyExists(String email) throws Exception {
            return userRepository.findByEmail(email).isPresent();
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
    public UserDTO deleteUser(String id) {
        return modelMapper.map(userRepository.deleteByUserId(id), UserDTO.class)  ;
    }

    // TODO
//    delete during devel or work on it if I do a manage account
    @Override
    public List<UserDTO> findAll() {
        List<UserDTO> userDTOList = userRepository.findAll()
                .stream()
                .map(u -> modelMapper.map(u, UserDTO.class))
                .collect(Collectors.toList()) ;

        return userDTOList;
    }

    @Override
    public long count() {
        return userRepository.count();
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public ResponseEntity<UserDTO> login(MailAndPass mailAndPass) {
        Optional<UserDTO> user = Optional.ofNullable( findByEmail(mailAndPass.getEmail()));

        if (user.isPresent() && user.get().getPassword().equals(mailAndPass.getPassword())) {
            return new ResponseEntity<>(user.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new UserDTO(), HttpStatus.CONFLICT);
        }
    }
}
