package com.gereneciamento.tarefa.repostitory;

import java.util.List;
import com.gereneciamento.tarefa.modal.Tarefa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Tarefas extends JpaRepository<Tarefa, Integer>{
  
  List<Tarefa> findByUserId(Integer id);
  
}
