package app.vendingmachine.model

data class CoinBox(
    var deposit: Int,
    var deposit10: Int,
    var deposit50: Int,
    var deposit100: Int,
    var deposit500: Int,
    var deposit1000: Int,
    var left10: Int,
    var left50: Int,
    var left100: Int,
    var left500: Int,
    var left1000: Int
)