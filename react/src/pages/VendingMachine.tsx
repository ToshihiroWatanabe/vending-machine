import { Fragment, useEffect, useState } from "react";
import CoinBoxService from "services/CoinBox.service";

type CoinBox = {
  deposit: number;
  left10: number;
  left50: number;
  left100: number;
  left500: number;
  left1000: number;
};

type Stock = {
  id: number;
  name: string;
  temperature: string;
  price: number;
  quantity: number;
};

const VendingMachine = () => {
  const [coinBox, setCoinBox] = useState<CoinBox>();
  const [stocks, setStocks] = useState<Stock[]>([
    { id: 1, name: "商品1", temperature: "cold", price: 140, quantity: 24 },
    { id: 2, name: "商品2", temperature: "hot", price: 120, quantity: 24 },
  ]);

  useEffect(() => {
    CoinBoxService.get().then((res: any) => {
      console.log(res.data);
      setCoinBox(res.data);
    });
  }, []);

  const onInsertButtonClick = (value: number) => {
    CoinBoxService.insert(value).then((res: any) => {
      console.log(res.data);
      setCoinBox(res.data);
      console.log(value + "円が投入されました");
    });
  };

  const onReleaseButtonClick = () => {
    CoinBoxService.release().then((res: any) => {
      console.log(res.data);
      setCoinBox(res.data);
      console.log("おつり返却");
    });
  };

  return (
    <Fragment>
      <h1>自動販売機アプリ</h1>
      {stocks.map((stock) => {
        return (
          <button key={stock.id}>
            {stock.name}
            <br />
            {stock.temperature === "hot"
              ? "あたたかい"
              : stock.temperature === "cold"
              ? "つめたい"
              : ""}
            <br />
            {stock.quantity !== 0 ? stock.price + "円" : "売り切れ"}
          </button>
        );
      })}
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
      <table>
        <tr>
          <th>10円玉</th>
          <th>残り{coinBox?.left10}枚</th>
        </tr>
        <tr>
          <th>50円玉</th>
          <th>残り{coinBox?.left50}枚</th>
        </tr>
        <tr>
          <th>100円玉</th>
          <th>残り{coinBox?.left100}枚</th>
        </tr>
        <tr>
          <th>500円玉</th>
          <th>残り{coinBox?.left500}枚</th>
        </tr>
        <tr>
          <th>1000円札</th>
          <th>残り{coinBox?.left1000}枚</th>
        </tr>
      </table>
    </Fragment>
  );
};

export default VendingMachine;
