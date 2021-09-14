import axios from "axios";
import React, { useEffect, useState } from "react";
import "./App.css";

type CoinBox = {
  deposit: number;
  left10: number;
  left50: number;
  left100: number;
  left500: number;
  left1000: number;
};

function App() {
  const [coinBox, setCoinBox] = useState<CoinBox>();

  useEffect(() => {
    axios.get("http://localhost:8080/api/coin-box/").then((res) => {
      console.log(res.data);
      setCoinBox(res.data);
    });
  }, []);

  const onInsertButtonClick = (value: number) => {
    axios
      .patch("http://localhost:8080/api/coin-box/insert/" + value)
      .then((res) => {
        console.log(res.data);
        setCoinBox(res.data);
        console.log(value + "円が投入されました");
      });
  };

  const onReleaseButtonClick = () => {
    axios.patch("http://localhost:8080/api/coin-box/release").then((res) => {
      console.log(res.data);
      setCoinBox(res.data);
      console.log("おつり返却");
    });
  };

  return (
    <div className="App">
      <h1>自動販売機アプリ</h1>
      <p>投入金額: {coinBox?.deposit}円</p>
      <div>
        <button
          onClick={() => {
            onInsertButtonClick(10);
          }}
        >
          10円玉を入れる
        </button>
        <button
          onClick={() => {
            onInsertButtonClick(50);
          }}
        >
          50円玉を入れる
        </button>
        <button
          onClick={() => {
            onInsertButtonClick(100);
          }}
        >
          100円玉を入れる
        </button>
        <button
          onClick={() => {
            onInsertButtonClick(500);
          }}
        >
          500円玉を入れる
        </button>
        <button
          onClick={() => {
            onInsertButtonClick(1000);
          }}
        >
          1000円札を入れる
        </button>
      </div>
      <button
        onClick={() => {
          onReleaseButtonClick();
        }}
      >
        おつり・返却
      </button>
    </div>
  );
}

export default App;
