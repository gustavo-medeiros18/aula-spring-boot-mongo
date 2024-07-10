package com.nelioalves.workshopmongo.services;

import com.nelioalves.workshopmongo.domain.User;
import com.nelioalves.workshopmongo.dto.UserDTO;
import com.nelioalves.workshopmongo.repository.UserRepository;
import com.nelioalves.workshopmongo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserService {
  @Autowired
  private UserRepository repo;

  public List<User> findAll() {
    return repo.findAll();
  }

  public User findById(String id) {
    try {
      return repo.findById(id).orElseThrow();
    } catch (NoSuchElementException e) {
      throw new ObjectNotFoundException("Objeto não encontrado");
    }
  }

  public User insert(User obj) {
    return repo.insert(obj);
  }

  /**
   * This method was inserted in UserService instead of UserDto
   * because, in future updates, it might be necessary to access
   * the database when converting a UserDTO to a User. And the class
   * that holds the repository for accessing the database is UserService.
   */
  public User fromDTO(UserDTO obj) {
    return new User(obj.getId(), obj.getName(), obj.getEmail());
  }
}
