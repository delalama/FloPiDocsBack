package com.FloPiDocs.FloPiDocs.Content.service;

import com.FloPiDocs.FloPiDocs.Content.controller.UserController;
import com.FloPiDocs.FloPiDocs.Content.controller.utils.MailAndPass;
import com.FloPiDocs.FloPiDocs.Content.entities.User;
import com.FloPiDocs.FloPiDocs.Content.entities.dto.UserDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

@SuppressWarnings("ALL")
public interface UserService {
    public abstract ResponseEntity createUser(UserDTO userDTO);
    UserDTO deleteUser(String id);
    public abstract UserDTO findByEmail(String s);
    public abstract User findByUserId(String id);
    public abstract List<UserDTO> findAll();
    public abstract Boolean emailAlreadyExists(String email) throws Exception;
    public abstract void deleteAll();
    public long count();
    public abstract void save(User user);

    ResponseEntity login(MailAndPass mailAndPass);
}
