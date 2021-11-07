import Admin from "pages/Admin";
import VendingMachine from "pages/VendingMachine";
import { Route, Routes } from "react-router-dom";

const App = () => {
  return (
    <div className="App">
      <Routes>
        <Route path="/" element={<VendingMachine />} />
        <Route path="/admin" element={<Admin />} />
      </Routes>
    </div>
  );
};

export default App;
