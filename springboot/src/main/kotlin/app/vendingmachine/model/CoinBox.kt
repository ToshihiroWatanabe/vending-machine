package app.vendingmachine.model

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

@ApiModel(description = "投入金額とお釣り用のお金")
data class CoinBox(
    @ApiModelProperty(value = "投入金額", required = true)
    var deposit: Int,
    @ApiModelProperty(value = "10円玉の投入枚数", required = true)
    var deposit10: Int,
    @ApiModelProperty(value = "50円玉の投入枚数", required = true)
    var deposit50: Int,
    @ApiModelProperty(value = "100円玉の投入枚数", required = true)
    var deposit100: Int,
    @ApiModelProperty(value = "500円玉の投入枚数", required = true)
    var deposit500: Int,
    @ApiModelProperty(value = "1000円札の投入枚数", required = true)
    var deposit1000: Int,
    @ApiModelProperty(value = "10円玉の残り枚数", required = true)
    var left10: Int,
    @ApiModelProperty(value = "50円玉の残り枚数", required = true)
    var left50: Int,
    @ApiModelProperty(value = "100円玉の残り枚数", required = true)
    var left100: Int,
    @ApiModelProperty(value = "500円玉の残り枚数", required = true)
    var left500: Int,
    @ApiModelProperty(value = "1000円札の残り枚数", required = true)
    var left1000: Int
)