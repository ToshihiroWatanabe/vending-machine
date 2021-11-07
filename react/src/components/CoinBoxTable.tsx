import { CoinBox } from "types/CoinBox";

type Props = {
  coinBox?: CoinBox;
  isButtonVisibled: Boolean;
  onAdjustButtonClick: Function;
  onWithdrawButtonClick: Function;
};

const coins = [10, 50, 100, 500];

/**
 * お金の表のコンポーネントです。
 * @param props
 */
const CoinBoxTable = (props: Props) => {
  return (
    <>
      <h4>自動販売機の中のお金</h4>
      <table>
        <tbody>
          {coins.map((coin) => {
            return (
              <tr key={coin}>
                <th>{coin}円玉</th>
                <th>
                  {/* @ts-ignore */}
                  {props.coinBox ? props.coinBox["left" + coin] + "枚" : ""}
                </th>
                {props.isButtonVisibled && (
                  <>
                    <th>
                      <button
                        onClick={() => {
                          props.onAdjustButtonClick(coin);
                        }}
                      >
                        調整
                      </button>
                    </th>
                    <th>
                      <button
                        onClick={() => {
                          props.onWithdrawButtonClick(coin);
                        }}
                      >
                        回収
                      </button>
                    </th>
                  </>
                )}
              </tr>
            );
          })}
          <tr>
            <th>1000円札</th>
            <th>{props.coinBox?.left1000}枚</th>
            {props.isButtonVisibled && (
              <>
                <th></th>
                <th>
                  <button
                    onClick={() => {
                      props.onWithdrawButtonClick(1000);
                    }}
                  >
                    回収
                  </button>
                </th>
              </>
            )}
          </tr>
        </tbody>
      </table>
    </>
  );
};

export default CoinBoxTable;
