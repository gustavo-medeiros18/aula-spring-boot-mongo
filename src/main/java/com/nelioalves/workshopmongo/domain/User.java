package com.nelioalves.workshopmongo.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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

  /**
   * DBRef annotation is used to indicate that this field
   * is a reference to another document. lazy attribute is
   * used to indicate that the reference will be loaded only
   * when it is accessed.
   */
  @DBRef(lazy = true)
  private List<Post> posts = new ArrayList<>();

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

  public List<Post> getPosts() {
    return posts;
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

  public void setPosts(List<Post> posts) {
    this.posts = posts;
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
