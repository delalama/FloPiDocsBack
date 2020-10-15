package com.FloPiDocs.FloPiDocs.Content.repository;

import com.FloPiDocs.FloPiDocs.Content.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    public User findByFirstName(String firstName);
    public List<User> findByLastName(String lastName);
    public User findByEmail(String email);
    public List<User> findAll();
    public void deleteAll();
    public long count();
    public User findById(Long id);
}