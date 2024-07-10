package com.nelioalves.workshopmongo.dto;

import com.nelioalves.workshopmongo.domain.User;

import java.io.Serializable;

public class UserDTO implements Serializable {
  private String id;
  private String name;
  private String email;

  public UserDTO() {

  }

  public UserDTO(User obj) {
    this.id = obj.getId();
    this.name = obj.getName();
    this.email = obj.getEmail();
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  public void setId(String id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}
