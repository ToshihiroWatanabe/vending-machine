package app.vendingmachine.model

import io.swagger.annotations.ApiModelProperty

/**
 *　投入金額とお釣り用のお金
 */
data class CoinBox(
    @ApiModelProperty(value = "投入金額", required = true)
    var deposit: Int,
    var deposit10: Int,
    var deposit50: Int,
    var deposit100: Int,
    var deposit500: Int,
    var deposit1000: Int,
    var left10: Int,
    var left50: Int,
    var left100: Int,
    var left500: Int,
    var left1000: Int
)