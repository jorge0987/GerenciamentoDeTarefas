package com.gereneciamento.tarefa.service.impl;

import java.util.List;
import java.util.Optional;

import com.gereneciamento.tarefa.modal.Tarefa;
import com.gereneciamento.tarefa.modal.User;
import com.gereneciamento.tarefa.repostitory.Tarefas;
import com.gereneciamento.tarefa.repostitory.Users;
import com.gereneciamento.tarefa.service.TarefaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class TarefaServiceImpl implements TarefaService {

  @Autowired
  private Tarefas repostitoryTarefa;

  @Autowired
  private Users repostitoryUsers;

  @Override
  public Tarefa saveTarefa(Integer id, Tarefa tarefa) {
    Tarefa tarefaSave = new Tarefa();
    repostitoryUsers.findById(id).map(user -> {

      tarefaSave.setNome(tarefa.getNome());
      tarefaSave.setDescricao(tarefa.getDescricao());
      tarefaSave.setUser(user);

      repostitoryTarefa.save(tarefaSave);

      return tarefaSave;
    });

    return null;
  }

  @Override
  public List<Tarefa> getTarefas(Integer id) {

    Optional<User> user = repostitoryUsers.findById(id);
    if (user.isPresent()) {
      User user2 = user.get();
      return repostitoryTarefa.findByUserId(user2.getId());
    } else {
      return null;
    }
  }

  @Override
  public Tarefa getTarefa(Integer userId, Integer tarefaId) {
    Optional<Tarefa> teste = repostitoryTarefa
        .findByUserId(userId)
        .stream()
        .filter(user -> user.getId().equals(tarefaId)).findFirst();

    return teste.get();
  }

  @Override
  public void deleteTarefa(Integer userId, Integer tarefaId) {
    if (repostitoryUsers.findById(userId).isPresent()) {
      repostitoryTarefa.findById(tarefaId)
          .map(tarefa -> {
            repostitoryTarefa.delete(tarefa);
            return tarefa;
          })
          .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "tarefa não existente!"));
    }
  }

  @Override
  public void updateTarefa(Integer userId, Integer tarefaId, Tarefa tarefa) {
    if (repostitoryUsers.findById(userId).isPresent()) {
      repostitoryTarefa
          .findById(tarefaId)
          .map(tarefaExistente -> {
            tarefa.setId(tarefaExistente.getId());
            tarefa.setUser(repostitoryUsers.findById(userId).get());
            repostitoryTarefa.save(tarefa);
            return ResponseEntity.noContent().build();
          }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "tarefa não encontrado"));
    }
  }

}