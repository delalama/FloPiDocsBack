package com.FloPiDocs.FloPiDocs.Content.service;

import com.FloPiDocs.FloPiDocs.Content.entities.User;
import com.FloPiDocs.FloPiDocs.Content.entities.dto.UserDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    public abstract ResponseEntity createUser(UserDTO userDTO);
    public abstract void deleteUser(String id);
    public abstract UserDTO findByEmail(String s);
    public abstract User findByUserId(String id);
    public abstract List<User> findAll();
    public abstract Boolean emailAlreadyExists(String email);
    public abstract void deleteAll();
    public long count();
    public abstract void save(User user);

}
