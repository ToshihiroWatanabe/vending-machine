import { CoinBox } from "types/CoinBox";
import { Stock } from "types/Stock";
import { Fragment, useEffect, useState } from "react";
import CoinBoxService from "services/CoinBox.service";
import StockService from "services/Stock.service";
import PurchaseService from "services/Purchase.service";
import CoinBoxTable from "components/CoinBoxTable";
import { Link } from "react-router-dom";

const VendingMachine = () => {
  const [coinBox, setCoinBox] = useState<CoinBox>({
    deposit: 0,
    deposit10: 0,
    deposit50: 0,
    deposit100: 0,
    deposit500: 0,
    deposit1000: 0,
    left10: 0,
    left50: 0,
    left100: 0,
    left500: 0,
    left1000: 0,
  });
  const [stocks, setStocks] = useState<Stock[]>([
    {
      id: 1,
      name: "読込中...",
      temperature: "cold",
      price: 9999,
      quantity: 24,
    },
  ]);

  useEffect(() => {
    document.title = "自動販売機アプリ";
    CoinBoxService.get().then((res: any) => {
      setCoinBox(res.data);
    });
    StockService.get().then((res: any) => {
      setStocks(res.data);
    });
  }, []);

  const onInsertButtonClick = (value: number) => {
    CoinBoxService.insert(value).then((res: any) => {
      setCoinBox(res.data);
    });
  };

  const onReleaseButtonClick = () => {
    CoinBoxService.release().then((res: any) => {
      setCoinBox(res.data);
    });
  };

  const onPurchaseButtonClick = (id: number) => {
    PurchaseService.post(id).then((res: any) => {
      // 情報を更新
      CoinBoxService.get().then((res: any) => {
        setCoinBox(res.data);
      });
      StockService.get().then((res: any) => {
        setStocks(res.data);
      });
    });
  };

  return (
    <Fragment>
      <h1>自動販売機アプリ</h1>
      {stocks.map((stock) => {
        return (
          <button
            key={stock.id}
            onClick={() => {
              onPurchaseButtonClick(stock.id);
            }}
            disabled={stock.price > coinBox?.deposit || stock.quantity <= 0}
          >
            {stock.name}
            <br />
            {stock.temperature === "hot"
              ? "あたたかい"
              : stock.temperature === "cold"
              ? "つめたい"
              : ""}
            <br />
            {stock.quantity > 0 ? stock.price + "円" : "売り切れ"}
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
      <hr />
      <CoinBoxTable
        coinBox={coinBox}
        isAdjustButtonVisibled={false}
        onAdjustButtonClick={() => {}}
      />
      <Link to="/admin">管理画面へ</Link>
    </Fragment>
  );
};

export default VendingMachine;
