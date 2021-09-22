import { Fragment, useEffect, useState } from "react";
import { Link } from "react-router-dom";
import ProductService from "services/Product.service";

type Product = {
  id: string;
  name: string;
  price: number;
  temperature: string;
  vendorName: string;
};

const Admin = () => {
  const [products, setProducts] = useState<Product[]>();

  useEffect(() => {
    ProductService.get().then((res) => {
      setProducts(res.data);
    });
  }, []);

  return (
    <Fragment>
      <h1>自動販売機アプリ - 管理者ページ</h1>
      <Link to="/">ホームに戻る</Link>
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
    </Fragment>
  );
};

export default Admin;
