package app.vendingmachine.model

data class CoinBox(
    var deposit: Int,
    var left10: Int,
    var left50: Int,
    var left100: Int,
    var left500: Int,
    var left1000: Int
)