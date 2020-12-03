package com.FloPiDocs.FloPiDocs.Content.repository;

import com.FloPiDocs.FloPiDocs.Content.model.persistence.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * The interface User repository.
 */
@SuppressWarnings("ALL")
@Repository
public interface UserRepository extends MongoRepository<User, String> {
    /**
     * Find by first name user.
     *
     * @param firstName the first name
     * @return the user
     */
    public User findByFirstName(String firstName);

    /**
     * Find by last name list.
     *
     * @param lastName the last name
     * @return the list
     */
    public List<User> findByLastName(String lastName);

    /**
     * Find by email optional.
     *
     * @param email the email
     * @return the optional
     */
    public Optional<User> findByEmail(String email);

    /**
     * Find by user id user.
     *
     * @param id the id
     * @return the user
     */
    public User findByUserId(String id);

    /**
     * Delete by user id user.
     *
     * @param id the id
     * @return the user
     */
    public User deleteByUserId(String id);
    public List<User> findAll();
    public long count();

}