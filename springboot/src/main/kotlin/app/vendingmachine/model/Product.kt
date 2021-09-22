package app.vendingmachine.model

data class Product(
    var id: String,
    var name: String,
    var temperature: String,
    var price: Int,
    var vendorName: String
)