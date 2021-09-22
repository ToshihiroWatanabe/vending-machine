package app.vendingmachine.model

data class StockResponse(
    var id: Int,
    var name: String,
    var temperature: String,
    var price: Int,
    var quantity: Int,
)
