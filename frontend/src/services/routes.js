import React from "react";
import { Routes, Route } from "react-router-dom";

import Tarefa from "../pages/Tarefas";
import SignIn from "../pages/singIn";
import SignUp from "../pages/singUp";

const RoutesList = () => (
  <Routes>
    <Route path="/" element={<Tarefa />} />

    <Route path="/tarefas" element={<Tarefa />} />
    <Route path="/signin" element={<SignIn />} />
    <Route path="/signup" element={<SignUp />} />

    <Route path="*" element={<Tarefa />} />
  </Routes>
);

export default RoutesList;
