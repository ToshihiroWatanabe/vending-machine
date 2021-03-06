import { Stock } from "types/Stock";

type Props = {
  stocks?: Stock[];
  onSupplyButtonClick: Function;
};

/**
 * 在庫の表のコンポーネントです。
 * @param props
 */
const StockTable = (props: Props) => {
  return (
    <>
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
                      props.onSupplyButtonClick(stock.id);
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
    </>
  );
};

export default StockTable;
