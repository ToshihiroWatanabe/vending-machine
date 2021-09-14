import axios from "axios";
import React, { useEffect } from "react";
import "./App.css";

function App() {
  useEffect(() => {
    axios.get("http://localhost:8080/api/coin-box/").then((res) => {
      console.log(res);
    });
  }, []);
  return (
    <div className="App">
      <h1>自動販売機アプリ</h1>
    </div>
  );
}

export default App;
