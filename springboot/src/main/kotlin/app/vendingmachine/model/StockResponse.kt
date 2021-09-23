package app.vendingmachine.model

/**
 * 在庫と商品情報を結合したもの
 */
data class StockResponse(
    var id: Int,
    var name: String,
    var temperature: String,
    var price: Int,
    var quantity: Int,
)
