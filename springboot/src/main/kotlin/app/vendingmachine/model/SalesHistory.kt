package app.vendingmachine.model

import java.time.LocalDateTime

data class SalesHistory(
    var id: String,
    var purchaseTime: LocalDateTime,
    var productId: String
)
