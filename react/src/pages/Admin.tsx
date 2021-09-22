import CoinBoxTable from "components/CoinBoxTable";
import { Fragment, useEffect, useState } from "react";
import { Link } from "react-router-dom";
import CoinBoxService from "services/CoinBox.service";
import ProductService from "services/Product.service";
import SalesHistoryService from "services/SalesHistory.service";
import { CoinBox } from "types/CoinBox";

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

  useEffect(() => {
    ProductService.get().then((res) => {
      setProducts(res.data);
    });
    SalesHistoryService.get().then((res) => {
      setSalesHistory(res.data);
    });
    CoinBoxService.get().then((res) => {
      setCoinBox(res.data);
    });
  }, []);

  return (
    <Fragment>
      <h1>自動販売機アプリ - 管理者ページ</h1>
      <Link to="/">ホームに戻る</Link>
      <CoinBoxTable coinBox={coinBox} />
      <table>
        <thead>
          <tr>
            <th>ID</th>
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
                <th>{product.temperature}</th>
                <th>{product.vendorName}</th>
              </tr>
            );
          })}
        </tbody>
      </table>
      <table>
        <thead>
          <tr>
            <th>履歴ID</th>
            <th>購入時刻</th>
            <th>商品ID</th>
          </tr>
        </thead>
        <tbody>
          {salesHistory?.map((history) => {
            return (
              <tr key={history.id}>
                <th>{history.id}</th>
                <th>{history.purchaseTime}</th>
                <th>{history.productId}</th>
              </tr>
            );
          })}
        </tbody>
      </table>
    </Fragment>
  );
};

export default Admin;
