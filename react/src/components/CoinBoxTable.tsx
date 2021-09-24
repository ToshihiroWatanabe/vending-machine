import { Fragment } from "react";
import { CoinBox } from "types/CoinBox";

type Props = {
  coinBox?: CoinBox;
  isButtonVisibled: Boolean;
  onAdjustButtonClick: Function;
  onWithdrawButtonClick: Function;
};

const CoinBoxTable = (props: Props) => {
  return (
    <Fragment>
      <h4>自動販売機の中のお金</h4>
      <table>
        <tbody>
          <tr>
            <th>10円玉</th>
            <th>{props.coinBox?.left10}枚</th>
            {props.isButtonVisibled && (
              <Fragment>
                <th>
                  <button
                    onClick={() => {
                      props.onAdjustButtonClick(10);
                    }}
                  >
                    調整
                  </button>
                </th>
                <th>
                  <button
                    onClick={() => {
                      props.onWithdrawButtonClick(10);
                    }}
                  >
                    回収
                  </button>
                </th>
              </Fragment>
            )}
          </tr>
          <tr>
            <th>50円玉</th>
            <th>{props.coinBox?.left50}枚</th>
            {props.isButtonVisibled && (
              <Fragment>
                <th>
                  <button
                    onClick={() => {
                      props.onAdjustButtonClick(50);
                    }}
                  >
                    調整
                  </button>
                </th>
                <th>
                  <button
                    onClick={() => {
                      props.onWithdrawButtonClick(50);
                    }}
                  >
                    回収
                  </button>
                </th>
              </Fragment>
            )}
          </tr>
          <tr>
            <th>100円玉</th>
            <th>{props.coinBox?.left100}枚</th>
            {props.isButtonVisibled && (
              <Fragment>
                <th>
                  <button
                    onClick={() => {
                      props.onAdjustButtonClick(100);
                    }}
                  >
                    調整
                  </button>
                </th>
                <th>
                  <button
                    onClick={() => {
                      props.onWithdrawButtonClick(100);
                    }}
                  >
                    回収
                  </button>
                </th>
              </Fragment>
            )}
          </tr>
          <tr>
            <th>500円玉</th>
            <th>{props.coinBox?.left500}枚</th>
            {props.isButtonVisibled && (
              <Fragment>
                <th>
                  <button
                    onClick={() => {
                      props.onAdjustButtonClick(500);
                    }}
                  >
                    調整
                  </button>
                </th>
                <th>
                  <button
                    onClick={() => {
                      props.onWithdrawButtonClick(500);
                    }}
                  >
                    回収
                  </button>
                </th>
              </Fragment>
            )}
          </tr>
          <tr>
            <th>1000円札</th>
            <th>{props.coinBox?.left1000}枚</th>
            {props.isButtonVisibled && (
              <Fragment>
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
              </Fragment>
            )}
          </tr>
        </tbody>
      </table>
    </Fragment>
  );
};

export default CoinBoxTable;
