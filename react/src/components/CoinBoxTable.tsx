import { Fragment } from "react";
import { CoinBox } from "types/CoinBox";

type Props = {
  coinBox?: CoinBox;
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
            {/* <th>投入中{props.coinBox?.deposit10}枚</th> */}
          </tr>
          <tr>
            <th>50円玉</th>
            <th>{props.coinBox?.left50}枚</th>
            {/* <th>投入中{props.coinBox?.deposit50}枚</th> */}
          </tr>
          <tr>
            <th>100円玉</th>
            <th>{props.coinBox?.left100}枚</th>
            {/* <th>投入中{props.coinBox?.deposit100}枚</th> */}
          </tr>
          <tr>
            <th>500円玉</th>
            <th>{props.coinBox?.left500}枚</th>
            {/* <th>投入中{props.coinBox?.deposit500}枚</th> */}
          </tr>
          <tr>
            <th>1000円札</th>
            <th>{props.coinBox?.left1000}枚</th>
            {/* <th>投入中{props.coinBox?.deposit1000}枚</th> */}
          </tr>
        </tbody>
      </table>
    </Fragment>
  );
};

export default CoinBoxTable;
