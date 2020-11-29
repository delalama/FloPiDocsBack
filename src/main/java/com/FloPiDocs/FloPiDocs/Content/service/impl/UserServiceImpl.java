package com.FloPiDocs.FloPiDocs.Content.service.impl;

import com.FloPiDocs.FloPiDocs.Content.controller.utils.MailAndPass;
import com.FloPiDocs.FloPiDocs.Content.model.dto.AccountOptionsDTO;
import com.FloPiDocs.FloPiDocs.Content.model.dto.UserDTO;
import com.FloPiDocs.FloPiDocs.Content.model.persistence.User;
import com.FloPiDocs.FloPiDocs.Content.exception.InvalidLoginException;
import com.FloPiDocs.FloPiDocs.Content.repository.UserRepository;
import com.FloPiDocs.FloPiDocs.Content.service.AccountOptionsService;
import com.FloPiDocs.FloPiDocs.Content.service.DocumentService;
import com.FloPiDocs.FloPiDocs.Content.service.UserService;
import com.FloPiDocs.FloPiDocs.Content.service.encryptor.Encryptor;
import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    //TODO ACTUAL, APRENDER A USAR JASYPT
    final ModelMapper modelMapper = new ModelMapper();

    @Autowired
    UserRepository userRepository;

    @Autowired
    private DocumentService documentService;

    @Autowired
    private Encryptor encryptor;

    final String password = "Test!email30#password";

    @Autowired
    private AccountOptionsService accountOptionsService;

    @Autowired
    private ConversionService conversionService;

    @Override
    public ResponseEntity createUser(UserDTO userDTO) throws Exception {
        userDTO.setPassword(encryptor.encrypt(userDTO.getPassword()));
        // Create user
        User userCreated = userRepository.save(conversionService.convert(userDTO, User.class));

        UserDTO userCreatedDto = conversionService.convert(userCreated, UserDTO.class);

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

    @Override
    public Optional<UserDTO> findByEmail(String email) {

        Optional<User> user = userRepository.findByEmail(email);

        return user.map(value -> conversionService.convert(value, UserDTO.class));
    }

    @Override
    public User findByUserId(String id) {
        return userRepository.findByUserId(id);
    }

    @Override
    public void deleteUser(String id) {
        documentService.deleteAllByUserId(id);
        accountOptionsService.deleteByUserId(id);
        userRepository.deleteById(id);
    }

    @Override
    public List<UserDTO> findAll() {
        return userRepository.findAll()
                .stream()
                .map(u -> conversionService.convert(u, UserDTO.class))
                .collect(Collectors.toList());
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
    public UserDTO login(MailAndPass mailAndPass) throws Exception {
        mailAndPass.setPassword(encryptor.encrypt(mailAndPass.getPassword()));

        Optional<UserDTO> user = findByEmail(mailAndPass.getEmail());

        if (user.isPresent() && StringUtils.equals(user.get().getPassword(), mailAndPass.getPassword())) {
            return user.get();
        } else {
            throw new InvalidLoginException();
        }
    }
    @Override
    public void deleteAllContent() {
        userRepository.findAll().forEach( user -> deleteUser(user.getUserId()));
    }
}

