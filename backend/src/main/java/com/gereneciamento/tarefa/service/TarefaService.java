package com.gereneciamento.tarefa.service;

import java.util.List;
import com.gereneciamento.tarefa.modal.Tarefa;

public interface TarefaService {

  Tarefa saveTarefa(Integer id, Tarefa tarefa);

  // void updateTarefa(Integer idUser, Integer idTarefa, Tarefa tarefa);

  Tarefa getTarefa(Integer userId, Integer tarefaId);

  List<Tarefa> getTarefas(Integer id);

  void updateTarefa(Integer userId, Integer tarefaId, Tarefa tarefa);


  void deleteTarefa(Integer userId, Integer tarefaId);

}
