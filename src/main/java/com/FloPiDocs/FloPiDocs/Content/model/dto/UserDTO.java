package com.FloPiDocs.FloPiDocs.Content.model.dto;

import lombok.*;

/**
 * The type User dto.
 */
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Builder
public class UserDTO {
    private String userId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String token;


    /**
     * Instantiates a new User dto.
     *
     * @param firstName the first name
     * @param lastName  the last name
     * @param email     the email
     * @param password  the password
     */
    public UserDTO(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }


}
