package com.FloPiDocs.FloPiDocs.Content.service.impl;

import com.FloPiDocs.FloPiDocs.Content.repository.UserRepository;
import com.FloPiDocs.FloPiDocs.Content.entities.User;
import com.FloPiDocs.FloPiDocs.Content.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public void createUser(User user) {
        if(userRepository.findByEmail(user.email ) == null){
            userRepository.save(user);
        }else{
            System.out.println("Email exists");
        }
    }

    @Override
    public boolean emailExists(String email){
        User user = userRepository.findByEmail(email);
        if ( user != null ) {
            return true;
        }else{
            return false;
        }
    }

    @Override
    public void deleteAll() {
        userRepository.deleteAll();
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User findById(String id) {
        return null;
    }

    @Override
    public void deleteUser(String id) {

    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
