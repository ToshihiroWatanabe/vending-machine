import CoinBoxTable from "components/CoinBoxTable";
import StockTable from "components/StockTable";
import { Fragment, useEffect, useState } from "react";
import { Link } from "react-router-dom";
import CoinBoxService from "services/CoinBox.service";
import ProductService from "services/Product.service";
import SalesHistoryService from "services/SalesHistory.service";
import StockService from "services/Stock.service";
import { CoinBox } from "types/CoinBox";
import { Stock } from "types/Stock";

type Product = {
  id: string;
  name: string;
  price: number;
  temperature: string;
  vendorName: string;
};

type SalesHistory = {
  id: string;
  purchaseTime: string;
  productId: string;
};

const Admin = () => {
  const [products, setProducts] = useState<Product[]>();
  const [salesHistory, setSalesHistory] = useState<SalesHistory[]>();
  const [coinBox, setCoinBox] = useState<CoinBox>();
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
    document.title = "自動販売機アプリ - 管理画面";
    ProductService.get().then((res) => {
      setProducts(res.data);
    });
    SalesHistoryService.get().then((res) => {
      setSalesHistory(res.data);
    });
    CoinBoxService.get().then((res) => {
      setCoinBox(res.data);
    });
    StockService.get().then((res) => {
      setStocks(res.data);
    });
  }, []);

  /**
   * 補充ボタンが押された時の処理です。
   * @param id 在庫ID
   */
  const onSupplyButtonClick = (id: number) => {
    StockService.supply(id, 24).then((res) => {
      StockService.get().then((res) => {
        setStocks(res.data);
      });
    });
  };

  /**
   * 販売履歴を全て削除するボタンが押された時の処理です。
   */
  const onSalesHistoryDeleteAllButtonClick = () => {
    SalesHistoryService.deleteAll().then((res) => {
      SalesHistoryService.get().then((res) => {
        setSalesHistory(res.data);
      });
    });
  };

  /**
   * お金の調整ボタンが押された時の処理です。
   */
  const onAdjustButtonClick = (money: number) => {
    CoinBoxService.adjust(money).then((res) => {
      setCoinBox(res.data);
    });
  };

  /**
   * お金の回収ボタンが押された時の処理です。
   */
  const onWithdrawButtonClick = (money: number) => {
    CoinBoxService.withdraw(money).then((res) => {
      setCoinBox(res.data);
    });
  };

  return (
    <Fragment>
      <h1>自動販売機アプリ - 管理画面</h1>
      <Link to="/">ホームに戻る</Link>
      <CoinBoxTable
        coinBox={coinBox}
        isButtonVisibled={true}
        onAdjustButtonClick={onAdjustButtonClick}
        onWithdrawButtonClick={onWithdrawButtonClick}
      />
      <StockTable stocks={stocks} onSupplyButtonClick={onSupplyButtonClick} />
      <h4>商品一覧</h4>
      <table>
        <thead>
          <tr>
            <th>商品ID</th>
            <th>商品名</th>
            <th>価格</th>
            <th>温度</th>
            <th>製造者名</th>
          </tr>
        </thead>
        <tbody>
          {products?.map((product) => {
            return (
              <tr key={product.id}>
                <th>{product.id}</th>
                <th>{product.name}</th>
                <th>{product.price}</th>
                <th>
                  {product.temperature === "cold" ? "つめたい" : "あたたかい"}
                </th>
                <th>{product.vendorName}</th>
              </tr>
            );
          })}
        </tbody>
      </table>
      <details>
        <summary>販売履歴</summary>
        <button
          onClick={() => {
            onSalesHistoryDeleteAllButtonClick();
          }}
        >
          履歴を全て削除
        </button>
        <table>
          <thead>
            <tr>
              <th>販売時刻</th>
              <th>商品ID</th>
            </tr>
          </thead>
          <tbody>
            {salesHistory?.map((history) => {
              return (
                <tr key={history.id}>
                  <th>{history.purchaseTime}</th>
                  <th>{history.productId}</th>
                </tr>
              );
            })}
          </tbody>
        </table>
      </details>
    </Fragment>
  );
};

export default Admin;
