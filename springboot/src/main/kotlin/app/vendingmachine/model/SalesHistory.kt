package app.vendingmachine.model

import java.time.LocalDateTime

/**
 * 販売履歴
 */
data class SalesHistory(
    var id: String,
    var purchaseTime: LocalDateTime,
    var productId: String
)
