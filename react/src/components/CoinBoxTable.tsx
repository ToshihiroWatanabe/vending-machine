import { Fragment } from "react";
import { CoinBox } from "types/CoinBox";

type Props = {
  coinBox?: CoinBox;
  isAdjustButtonVisibled: Boolean;
  onAdjustButtonClick: Function;
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
            {props.isAdjustButtonVisibled && (
              <th>
                <button
                  onClick={() => {
                    props.onAdjustButtonClick(10);
                  }}
                >
                  調整
                </button>
              </th>
            )}
          </tr>
          <tr>
            <th>50円玉</th>
            <th>{props.coinBox?.left50}枚</th>
            {props.isAdjustButtonVisibled && (
              <th>
                <button
                  onClick={() => {
                    props.onAdjustButtonClick(50);
                  }}
                >
                  調整
                </button>
              </th>
            )}
          </tr>
          <tr>
            <th>100円玉</th>
            <th>{props.coinBox?.left100}枚</th>
            {props.isAdjustButtonVisibled && (
              <th>
                <button
                  onClick={() => {
                    props.onAdjustButtonClick(100);
                  }}
                >
                  調整
                </button>
              </th>
            )}
          </tr>
          <tr>
            <th>500円玉</th>
            <th>{props.coinBox?.left500}枚</th>
            {props.isAdjustButtonVisibled && (
              <th>
                <button
                  onClick={() => {
                    props.onAdjustButtonClick(500);
                  }}
                >
                  調整
                </button>
              </th>
            )}
          </tr>
          <tr>
            <th>1000円札</th>
            <th>{props.coinBox?.left1000}枚</th>
            {props.isAdjustButtonVisibled && (
              <th>
                <button
                  onClick={() => {
                    props.onAdjustButtonClick(1000);
                  }}
                >
                  調整
                </button>
              </th>
            )}
          </tr>
        </tbody>
      </table>
    </Fragment>
  );
};

export default CoinBoxTable;
