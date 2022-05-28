package com.gereneciamento.tarefa.rest.controller;

import com.gereneciamento.tarefa.modal.User;
import com.gereneciamento.tarefa.service.LoginService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class LoginController {
  
  @Autowired
  private LoginService loginService;

  @PostMapping("/login")
  public User login(@RequestBody User user){
    return loginService.loginUser(user);
  }
}
