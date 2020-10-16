package com.FloPiDocs.FloPiDocs.Content.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

@Getter
@Setter
public class User {
  @Indexed(unique = true)
  @Id
  private String userId;
  private String firstName;
  private String lastName;
  private String email;

  public User() {
  }

  public User(String firstName, String lastName, String email) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
  }

  public User(String id, String firstName, String lastName, String email) {
    this.userId = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
  }


  public void setUserId(String userId) { this.userId = userId; }

  public String getUserId() { return userId; }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}