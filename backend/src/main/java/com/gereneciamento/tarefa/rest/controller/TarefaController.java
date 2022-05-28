package com.gereneciamento.tarefa.rest.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.http.HttpStatus.*;
import java.util.List;
import com.gereneciamento.tarefa.modal.Tarefa;
import com.gereneciamento.tarefa.service.TarefaService;

@RestController
@RequestMapping("/api/tarefas/")
public class TarefaController {

  @Autowired
  private TarefaService service;

  @PostMapping("{id}/users")
  @ResponseStatus(CREATED)
  public Tarefa save(@PathVariable("id") Integer id, @RequestBody Tarefa tarefa) {
    return service.saveTarefa(id, tarefa);
  }

  @GetMapping("/{id}/users/{idTarefa}")
  public Tarefa tarefaFind(@PathVariable("id") Integer id, @PathVariable("idTarefa") Integer tarefaId) {
    return service.getTarefa(id, tarefaId);
  }

  @PutMapping("/{id}/users/{idTarefa}")
  @ResponseStatus(NO_CONTENT)
  public void updateTarefa(@PathVariable("id") Integer id, @PathVariable("idTarefa") Integer idTarefa, @RequestBody Tarefa tarefa){
    service.updateTarefa(id, idTarefa, tarefa);
  }
  
  @DeleteMapping("/{id}/users/{idTarefa}")
  @ResponseStatus(NO_CONTENT)
  public void deleteTarefa(@PathVariable("id") Integer id, @PathVariable("idTarefa") Integer tarefaId){
    service.deleteTarefa(id, tarefaId);
  }

  @GetMapping("{id}/users")
  @ResponseStatus(OK)
  public List<Tarefa> getTarefaList(@PathVariable("id") Integer id) {
    if(service.getTarefas(id) != null) {
      return service.getTarefas(id);
    }else {
       throw new IllegalStateException("Erro tarefa NOT exist");
    }
  }


}
