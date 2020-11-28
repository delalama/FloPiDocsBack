package com.FloPiDocs.FloPiDocs.Content.service;

import com.FloPiDocs.FloPiDocs.Content.controller.utils.MailAndPass;
import com.FloPiDocs.FloPiDocs.Content.model.persistence.User;
import com.FloPiDocs.FloPiDocs.Content.model.dto.UserDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("ALL")
public interface UserService {
    public abstract ResponseEntity createUser(UserDTO userDTO);

    void deleteUser(String id);

    public Optional<UserDTO> findByEmail(String s);

    public abstract User findByUserId(String id);

    public abstract List<UserDTO> findAll();

    public abstract Boolean emailAlreadyExists(String email) throws Exception;

    public abstract void deleteAll();

    public long count();

    public abstract void save(User user);

    UserDTO login(MailAndPass mailAndPass);

    void deleteAllContent();
}
