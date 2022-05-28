package com.gereneciamento.tarefa.rest.controller;

import java.util.List;

import com.gereneciamento.tarefa.modal.User;
import com.gereneciamento.tarefa.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class UserController {
  
  @Autowired
  private UserService service;

  @PostMapping("/users")
  @ResponseStatus(HttpStatus.CREATED)
  public User save(@RequestBody User user) {
    return service.saveFind(user);
  }

  @GetMapping("/users/{id}")
  public User userFind(@PathVariable Integer id) {
    return service.getFindById(id);
  }

  @DeleteMapping("/users/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(@PathVariable Integer id) {
    service.deleteFindById(id);
  }

  @PutMapping("/users/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void putUser( @PathVariable Integer id, @RequestBody User user ){
    service.updateFindById(id, user);
  }

  @GetMapping("/users")
  public List<User> usersAll() {
    return service.getUsers();
  }
  
}
