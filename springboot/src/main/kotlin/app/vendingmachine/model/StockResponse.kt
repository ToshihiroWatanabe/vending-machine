package app.vendingmachine.model

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

@ApiModel(description = "在庫と商品情報を結合したモデル")
data class StockResponse(
    @ApiModelProperty(value = "ID", required = true)
    var id: Int,
    @ApiModelProperty(value = "名前", required = true)
    var name: String,
    @ApiModelProperty(value = "温度", required = true)
    var temperature: String,
    @ApiModelProperty(value = "価格", required = true)
    var price: Int,
    @ApiModelProperty(value = "数量", required = true)
    var quantity: Int,
)
