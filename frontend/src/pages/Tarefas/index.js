import React, { useState } from "react";
import styledComponents from "styled-components";

const Container = styledComponents.div`
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    `;

function Tarefa() {
  const [tasks, setTasks] = useState([]);
  const [title, setTitle] = useState("");
  const [description, setDescription] = useState("");

  //função para adicionar o que foi digitado ao array de tasks (tasks são cada card: titulo e descrição)
  const handleSubmitForm = (e) => {
    e.preventDefault();

    const id = Date.now();

    const task = {
      id,
      title,
      description,
    };

    setTasks((prev) => [...prev, task]);

    setTitle("");
    setDescription("");
  };

  const handleDeleteTask = (id) => {
    //função que vai excluir a task que foi clicada
    //para excluir, a função vai retornar todas as tasks do array, menos a que foi clicada
    const newTasks = tasks.filter((task) => task.id !== id);

    setTasks(newTasks);
  };

  //formulário (título e descrição)
  return (
    <div class="container">
      <form onSubmit={handleSubmitForm} class="new-task-container">
        <div className="content-inputs">
          <input
            type="text"
            class="new-task-input"
            value={title}
            onChange={(e) => setTitle(e.target.value)}
            placeholder="Digite o título da tarefa..."
            required
          />
          <textarea
            className="new-task-input"
            placeholder="Digite a descrição da tarefa..."
            onChange={(e) => setDescription(e.target.value)}
            value={description}
            required
          />
        </div>

        <button type="submit" class="new-task-button">
          Adicionar
        </button>
      </form>

      {/* área que contém a listagem das tasks. Caso não tenha nenhuma, essa área desaparece*/}
      {tasks.length > 0 && (
        <div class="tasks-container">
          {/*array de tasks*/}
          {tasks.map((task) => (
            <div key={task.title} className="task-item">
              <div>
                <h3>{task.title}</h3>
                <p>{task.description}</p>
              </div>

              {/* botão para excluir a task*/}
              <button
                onClick={() => handleDeleteTask(task.id)}
                className="button-remove"
              >
                <i className="far fa-trash-alt"></i>
              </button>
            </div>
          ))}
        </div>
      )}
    </div>
  );
}

export default Tarefa;
