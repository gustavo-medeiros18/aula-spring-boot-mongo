package com.nelioalves.workshopmongo.services;

import com.nelioalves.workshopmongo.domain.User;
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
}
