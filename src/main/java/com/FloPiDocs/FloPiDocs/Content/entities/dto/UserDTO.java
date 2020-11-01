package com.FloPiDocs.FloPiDocs.Content.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class UserDTO {
    private String userId;
    private String firstName;
    private String lastName;
    private String email;
    private String passWord;
    private String token;
}
