import { Fragment } from "react";
import { Stock } from "types/Stock";

type Props = {
  stocks?: Stock[];
  onSupplyButtonClicked: Function;
};

const StockTable = (props: Props) => {
  return (
    <Fragment>
      <h4>在庫</h4>
      <table>
        <thead>
          <tr>
            <th>在庫ID</th>
            <th>商品名</th>
            <th>温度</th>
            <th>価格</th>
            <th>数量</th>
          </tr>
        </thead>
        <tbody>
          {props.stocks?.map((stock) => {
            return (
              <tr key={stock.id}>
                <th>{stock.id}</th>
                <th>{stock.name}</th>
                <th>
                  {stock.temperature === "cold" ? "つめたい" : "あたたかい"}
                </th>
                <th>{stock.price}</th>
                <th>{stock.quantity}</th>
                <th>
                  <button
                    onClick={() => {
                      props.onSupplyButtonClicked(stock.id);
                    }}
                    disabled={stock.quantity > 24}
                  >
                    補充
                  </button>
                </th>
              </tr>
            );
          })}
        </tbody>
      </table>
    </Fragment>
  );
};

export default StockTable;
