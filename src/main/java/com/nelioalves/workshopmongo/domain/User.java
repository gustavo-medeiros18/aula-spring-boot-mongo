package com.nelioalves.workshopmongo.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Objects;

/**
 * Document annotation is used to indicate that this
 * class is a MongoDB document. The collection attribute
 * can be used to specify the name of the collection where
 * the document will be stored. If not specified, the
 * collection name will be the same as the class name.
 */
@Document(collection = "user")
public class User implements Serializable {
  /**
   * Id annotation is used to indicate that this field
   * is the primary key of the document.
   */
  @Id
  private String id;
  private String name;
  private String email;

  public User() {

  }

  public User(String id, String name, String email) {
    this.id = id;
    this.name = name;
    this.email = email;
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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    User user = (User) o;
    return Objects.equals(id, user.id);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(id);
  }
}
