package com.gereneciamento.tarefa.service;

import java.util.List;

import com.gereneciamento.tarefa.modal.User;

import org.springframework.stereotype.Service;


public interface UserService {
  User saveFind(User user);

  User getFindById(Integer id);

  void deleteFindById(Integer id);

  void updateFindById(Integer id, User user);

  List<User> getUsers();
}
