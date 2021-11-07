package app.vendingmachine.model

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

@ApiModel(description = "在庫")
data class Stock(
    @ApiModelProperty(value = "在庫ID", required = true)
    var id: String,
    @ApiModelProperty(value = "商品ID", required = true)
    var productId: String,
    @ApiModelProperty(value = "数量", required = true)
    var quantity: Int
)
