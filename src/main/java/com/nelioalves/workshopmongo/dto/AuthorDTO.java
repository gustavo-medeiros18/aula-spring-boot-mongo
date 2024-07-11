package com.nelioalves.workshopmongo.dto;

import com.nelioalves.workshopmongo.domain.User;

public class AuthorDTO {
  private String id;
  private String name;

  public AuthorDTO() {
  }

  public AuthorDTO(User obj) {
    this.id = obj.getId();
    this.name = obj.getName();
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setId(String id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }
}
