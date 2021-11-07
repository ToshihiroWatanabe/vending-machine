package app.vendingmachine.model

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty

@ApiModel(description = "商品情報")
data class Product(
    @ApiModelProperty(value = "商品ID", required = true)
    var id: String,
    @ApiModelProperty(value = "商品名", required = true)
    var name: String,
    @ApiModelProperty(value = "温度", required = true)
    var temperature: String,
    @ApiModelProperty(value = "価格", required = true)
    var price: Int,
    @ApiModelProperty(value = "販売元", required = true)
    var vendorName: String
)