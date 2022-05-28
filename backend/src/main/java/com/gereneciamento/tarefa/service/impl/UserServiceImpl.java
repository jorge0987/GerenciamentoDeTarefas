package com.gereneciamento.tarefa.service.impl;

import java.util.List;

import com.gereneciamento.tarefa.modal.User;
import com.gereneciamento.tarefa.repostitory.Users;
import com.gereneciamento.tarefa.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserServiceImpl implements UserService{
  
  @Autowired
  private Users users;

  @Override
  public User saveFind(User user) {
    return users.save(user);
  }

  @Override
  public User getFindById(Integer id) {
    return users
    .findById(id)
    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não existente!"));
  }

  @Override
  public void deleteFindById(Integer id) {
    users.findById(id)
    .map( user -> { 
      users.delete(user);
      return user;
    })
    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario não existente!"));
  }

  @Override
  public void updateFindById(Integer id, User user) {
    users
    .findById(id)
    .map(userExistente -> {
      user.setId(userExistente.getId());
      users.save(user);
      return ResponseEntity.noContent().build();
    }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado"));
    
  }

  @Override
  public List<User> getUsers() {
    User filtro = new User();
    ExampleMatcher matcher = ExampleMatcher
        .matching()
        .withIgnoreCase()
        .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

    Example example = Example.of(filtro, matcher);
    return users.findAll(example);
  }
  
}
