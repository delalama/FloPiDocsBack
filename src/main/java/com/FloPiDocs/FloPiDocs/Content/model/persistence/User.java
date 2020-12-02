package com.FloPiDocs.FloPiDocs.Content.model.persistence;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

/**
 * The type User.
 */
@Data
@NoArgsConstructor
public class User {

    @Indexed(unique = true)
    @Id
    private String userId;
    private String firstName;
    private String lastName;
    private String email;
    private String passWord;

    /**
     * Instantiates a new User.
     *
     * @param firstName the first name
     * @param lastName  the last name
     * @param email     the email
     * @param passWord  the pass word
     */
    public User(String firstName, String lastName, String email, String passWord) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.passWord = passWord;
    }
}