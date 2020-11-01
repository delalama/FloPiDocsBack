package com.FloPiDocs.FloPiDocs.Content.entities;

import lombok.Getter;
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
  private String passWord;

  public User() {
  }

  public User(String firstName, String lastName, String email, String passWord) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.passWord = passWord;
  }


  public User(String userId, String firstName, String lastName, String email, String passWord) {
    this.userId = userId;
    this.firstName = firstName;
    this.lastName = lastName;
    this.passWord = passWord;
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

  public String getPassWord() { return passWord; }

  public void setPassWord(String passWord) { this.passWord = passWord; }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}