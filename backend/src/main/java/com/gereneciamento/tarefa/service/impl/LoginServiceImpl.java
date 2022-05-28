package com.gereneciamento.tarefa.service.impl;

import com.gereneciamento.tarefa.modal.User;
import com.gereneciamento.tarefa.repostitory.Users;
import com.gereneciamento.tarefa.service.LoginService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService{
  
  @Autowired
  private Users repostitoryUsers;

  @Override
  public User loginUser(User user) {
    User userExists = repostitoryUsers.findPasswordByEmail(user.getEmail(), user.getPassword());
    if (userExists != null) {
      return userExists;
    }

    return null;
  }

  
}
