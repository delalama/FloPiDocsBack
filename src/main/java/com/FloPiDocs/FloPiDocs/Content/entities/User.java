package com.FloPiDocs.FloPiDocs.Content.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@NoArgsConstructor
@Getter
@Setter
public class User {
  @Id
  public String id;

  public String firstName;
  public String lastName;
  public   String email;


  public User( String firstName, String lastName, String email) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
  }

}