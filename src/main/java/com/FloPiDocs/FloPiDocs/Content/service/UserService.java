package com.FloPiDocs.FloPiDocs.Content.service;

import com.FloPiDocs.FloPiDocs.Content.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    public abstract void createUser(User user);
    public abstract void deleteUser(String id);
    public abstract User findByEmail(String s);
    public abstract User findByUserId(String id);
    public abstract List<User> findAll();
    public abstract boolean emailExists(String email);
    public abstract void deleteAll();
    public long count();
    public abstract void save(User user);

}
