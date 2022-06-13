import { BrowserRouter } from "react-router-dom";
import RouterList from "./services/routes";

function App() {
  return (
    <BrowserRouter>
      <RouterList />
    </BrowserRouter>
  );
}

export default App;
