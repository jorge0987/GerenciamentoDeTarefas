package com.gereneciamento.tarefa.modal;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="tb_user")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name="nome", nullable= false)
  private String nome;

  @Column(name="email", unique = true)
  private String email;

  @Column(name="password", nullable= false)
  private String password;

  @JsonIgnore
  @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
  private List<Tarefa> tarefa;

}
