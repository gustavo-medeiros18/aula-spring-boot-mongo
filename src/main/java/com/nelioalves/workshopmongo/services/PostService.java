package com.nelioalves.workshopmongo.services;

import com.nelioalves.workshopmongo.domain.Post;
import com.nelioalves.workshopmongo.repository.PostRepository;
import com.nelioalves.workshopmongo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PostService {
  @Autowired
  private PostRepository repo;

  public Post findById(String id) {
    try {
      return repo.findById(id).orElseThrow();
    } catch (NoSuchElementException e) {
      throw new ObjectNotFoundException("Objeto não encontrado");
    }
  }

  public List<Post> findByTitle(String text) {
    return repo.findByTitleContainingIgnoreCase(text);
  }
}
