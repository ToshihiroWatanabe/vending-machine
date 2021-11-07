import { CoinBox } from "types/CoinBox";
import { Stock } from "types/Stock";
import { useEffect, useState } from "react";
import CoinBoxService from "services/CoinBox.service";
import StockService from "services/Stock.service";
import PurchaseService from "services/Purchase.service";
import CoinBoxTable from "components/CoinBoxTable";
import { Link } from "react-router-dom";

const coins = [10, 50, 100, 500];

/**
 * 自動販売機ページのコンポーネントです。
 */
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

  /**
   * お金を投入するボタンがクリックされた時の処理です。
   * @param value 投入するお金
   */
  const onInsertButtonClick = (value: number) => {
    CoinBoxService.insert(value).then((res: any) => {
      setCoinBox(res.data);
    });
  };

  /**
   * お釣りを返却するボタンがクリックされた時の処理です。
   */
  const onReleaseButtonClick = () => {
    CoinBoxService.release().then((res: any) => {
      setCoinBox(res.data);
    });
  };

  /**
   * 購入ボタンがクリックされた時の処理です。
   * @param id
   */
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

  /**
   * 購入可能かどうかを判定します。
   * @returns 購入可能ならtrue
   */
  const isPurchasable = (stock: Stock) => {
    // 数量が0以下ならfalse
    if (stock.quantity <= 0) return false;
    // 投入金額が価格未満ならfalse
    if (coinBox?.deposit < stock.price) return false;
    /** 残り投入金額 */
    let left = coinBox?.deposit - stock.price;
    const remainings = {};
    [1000, 500, 100, 50, 10].forEach((money) => {
      // @ts-ignore
      remainings[money] = coinBox["left" + money];
      while (left >= money) {
        // @ts-ignore
        if (remainings[money] <= 0) break;
        // @ts-ignore
        remainings[money]--;
        left -= money;
      }
    });
    return left === 0;
  };

  return (
    <>
      <h1>自動販売機アプリ</h1>
      {stocks.map((stock) => {
        return (
          <button
            key={stock.id}
            onClick={() => {
              onPurchaseButtonClick(stock.id);
            }}
            disabled={!isPurchasable(stock)}
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
        {coins.map((coin) => {
          return (
            <button
              key={coin}
              onClick={() => {
                onInsertButtonClick(coin);
              }}
            >
              {coin}円玉を入れる
            </button>
          );
        })}
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
        isButtonVisibled={false}
        onAdjustButtonClick={() => {}}
        onWithdrawButtonClick={() => {}}
      />
      <Link to="/admin">管理画面へ</Link>
    </>
  );
};

export default VendingMachine;
