package app.vendingmachine.model

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import java.time.LocalDateTime

@ApiModel(description = "販売履歴")
data class SalesHistory(
    @ApiModelProperty(value = "販売履歴ID", required = true)
    var id: String,
    @ApiModelProperty(value = "購入時刻", required = true)
    var purchaseTime: LocalDateTime,
    @ApiModelProperty(value = "商品ID", required = true)
    var productId: String
)
