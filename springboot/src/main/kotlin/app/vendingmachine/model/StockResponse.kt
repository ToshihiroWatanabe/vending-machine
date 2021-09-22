package app.vendingmachine.model

data class StockResponse(
    var id: Int,
    var productId: String,
    var quantity: Int,
    var name: String,
    var temperature: String,
    var price: Int
)
