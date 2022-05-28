package com.gereneciamento.tarefa.repostitory;

import javax.websocket.server.PathParam;

import com.gereneciamento.tarefa.modal.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface Users extends JpaRepository<User, Integer>{
  @Query(value = "select * from tb_user where email = ? and password = ?", nativeQuery = true)
  User findPasswordByEmail( String email, String password);
}
