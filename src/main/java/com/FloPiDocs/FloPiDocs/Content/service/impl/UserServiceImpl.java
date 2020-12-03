package com.FloPiDocs.FloPiDocs.Content.service.impl;

import com.FloPiDocs.FloPiDocs.Content.controller.utils.MailAndPass;
import com.FloPiDocs.FloPiDocs.Content.model.persistence.User;
import com.FloPiDocs.FloPiDocs.Content.exception.InvalidLoginException;
import com.FloPiDocs.FloPiDocs.Content.repository.UserRepository;
import com.FloPiDocs.FloPiDocs.Content.service.AccountOptionsService;
import com.FloPiDocs.FloPiDocs.Content.service.DocumentService;
import com.FloPiDocs.FloPiDocs.Content.service.UserService;
import com.FloPiDocs.FloPiDocs.Content.service.encryptor.Encryptor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * The type User service.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private DocumentService documentService;

    @Autowired
    private Encryptor encryptor;

    @Autowired
    private AccountOptionsService accountOptionsService;

    @Autowired
    private ConversionService conversionService;

    public UserServiceImpl() {
    }

    /**
     * Create User
     * This method encrypts the provided password.
     * Save the new user
     * Save the new user account Options
     * @param userDTO userDto
     * @return userDto
     * @throws Exception encryptor exception
     */
    @Override
    public com.FloPiDocs.FloPiDocs.Content.model.dto.UserDto createUser(com.FloPiDocs.FloPiDocs.Content.model.dto.UserDto userDTO) throws Exception {
        userDTO.setPassword(encryptor.encrypt(userDTO.getPassword()));
        // Create user
        User userCreated = userRepository.save(conversionService.convert(userDTO, User.class));

        com.FloPiDocs.FloPiDocs.Content.model.dto.UserDto userCreatedDto = conversionService.convert(userCreated, com.FloPiDocs.FloPiDocs.Content.model.dto.UserDto.class);

        // Create new user AccountOptions
        accountOptionsService.save(new com.FloPiDocs.FloPiDocs.Content.model.dto.AccountOptionsDto(userCreatedDto != null ? userCreatedDto.getUserId() : null));

        return userCreatedDto;
    }

    @Override
    public Boolean emailAlreadyExists(String email) {
        return userRepository.findByEmail(email).isPresent();
    }

    @Override
    public void deleteAll() {
        userRepository.deleteAll();
    }

    @Override
    public Optional<com.FloPiDocs.FloPiDocs.Content.model.dto.UserDto> findByEmail(String email) {

        Optional<User> user = userRepository.findByEmail(email);

        return user.map(value -> conversionService.convert(value, com.FloPiDocs.FloPiDocs.Content.model.dto.UserDto.class));
    }

    @Override
    public User findByUserId(String id) {
        return userRepository.findByUserId(id);
    }

    /**
     * Delete all user data
     * @param userId userId
     */
    @Override
    public void deleteUser(String userId) {
        documentService.deleteAllByUserId(userId);
        accountOptionsService.deleteByUserId(userId);
        userRepository.deleteById(userId);
    }

    @Override
    public List<com.FloPiDocs.FloPiDocs.Content.model.dto.UserDto> findAll() {
        return userRepository.findAll()
                .stream()
                .map(u -> conversionService.convert(u, com.FloPiDocs.FloPiDocs.Content.model.dto.UserDto.class))
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
    public com.FloPiDocs.FloPiDocs.Content.model.dto.UserDto login(MailAndPass mailAndPass) throws Exception {
        mailAndPass.setPassword(encryptor.encrypt(mailAndPass.getPassword()));

        Optional<com.FloPiDocs.FloPiDocs.Content.model.dto.UserDto> user = findByEmail(mailAndPass.getEmail());

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

