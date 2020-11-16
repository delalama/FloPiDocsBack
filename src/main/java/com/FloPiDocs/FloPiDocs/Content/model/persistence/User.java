package com.FloPiDocs.FloPiDocs.Content.model.persistence;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

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

    public User(String firstName, String lastName, String email, String passWord) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.passWord = passWord;
    }
}