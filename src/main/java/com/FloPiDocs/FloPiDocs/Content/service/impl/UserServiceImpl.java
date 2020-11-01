package com.FloPiDocs.FloPiDocs.Content.service.impl;

import com.FloPiDocs.FloPiDocs.Content.entities.dto.UserDTO;
import com.FloPiDocs.FloPiDocs.Content.repository.UserRepository;
import com.FloPiDocs.FloPiDocs.Content.entities.User;
import com.FloPiDocs.FloPiDocs.Content.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    ModelMapper modelMapper = new ModelMapper();
    @Autowired
    UserRepository userRepository;

    @Override
    public void createUser(User user) {
        if(userRepository.findByEmail(user.getEmail()) == null){
            userRepository.save(user);
        }else{
            System.out.println("Email exists");
        }
    }

    @Override
    public boolean emailExists(String email){
        User user = userRepository.findByEmail(email);
        return user != null;
    }

    @Override
    public void deleteAll() {
        userRepository.deleteAll();
    }

    public UserDTO findByEmail(String email) {
        return modelMapper.map(userRepository.findByEmail(email), UserDTO.class);
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
