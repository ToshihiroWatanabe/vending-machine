package app.vendingmachine.model

/**
 * 商品情報
 */
data class Product(
    var id: String,
    var name: String,
    var temperature: String,
    var price: Int,
    var vendorName: String
)