package app.vendingmachine.model

/**
 * 在庫
 */
data class Stock(
    var id: String,
    var productId: String,
    var quantity: Int
)
