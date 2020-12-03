package com.FloPiDocs.FloPiDocs.Content.service;

import com.FloPiDocs.FloPiDocs.Content.controller.utils.MailAndPass;
import com.FloPiDocs.FloPiDocs.Content.model.persistence.User;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

/**
 * The interface User service.
 */
@SuppressWarnings("ALL")
public interface UserService {
    /**
     * Create user response entity.
     *
     * @param userDTO the user dto
     * @return the response entity
     * @throws Exception the exception
     */
    public abstract ResponseEntity createUser(com.FloPiDocs.FloPiDocs.Content.model.dto.UserDto userDTO) throws Exception;

    /**
     * Delete user.
     *
     * @param id the id
     */
    void deleteUser(String id);

    /**
     * Find by email optional.
     *
     * @param s the s
     * @return the optional
     */
    public Optional<com.FloPiDocs.FloPiDocs.Content.model.dto.UserDto> findByEmail(String s);

    /**
     * Find by user id user.
     *
     * @param id the id
     * @return the user
     */
    public abstract User findByUserId(String id);

    /**
     * Find all list.
     *
     * @return the list
     */
    public abstract List<com.FloPiDocs.FloPiDocs.Content.model.dto.UserDto> findAll();

    /**
     * Email already exists boolean.
     *
     * @param email the email
     * @return the boolean
     */
    public abstract Boolean emailAlreadyExists(String email) ;

    /**
     * Delete all.
     */
    public abstract void deleteAll();

    /**
     * Count long.
     *
     * @return the long
     */
    public long count();

    /**
     * Save.
     *
     * @param user the user
     */
    public abstract void save(User user);

    /**
     * Login user dto.
     *
     * @param mailAndPass the mail and pass
     * @return the user dto
     * @throws Exception the exception
     */
    com.FloPiDocs.FloPiDocs.Content.model.dto.UserDto login(MailAndPass mailAndPass) throws Exception;

    /**
     * Delete all content.
     */
    void deleteAllContent();
}
