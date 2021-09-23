package app.vendingmachine.service

import app.vendingmachine.model.CoinBox
import app.vendingmachine.model.SalesHistory
import app.vendingmachine.model.Stock
import app.vendingmachine.model.StockResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.util.*
import java.util.Objects.isNull

/**
 * 購入に関するサービスクラスです。
 */
@Service
class PurchaseService @Autowired constructor(
    val stockService: StockService,
    val coinBoxService: CoinBoxService,
    val salesHistoryService: SalesHistoryService
) {

    /**
     * 指定された在庫IDの商品を購入します。
     */
    fun purchase(id: Int): Boolean {
//        TODO: トランザクション処理にする
//        指定されたIDのstockが存在するかチェック
        var stockProduct: StockResponse = stockService.findStockProductById(id)
        if (isNull(stockProduct)) {
            return false
        }
//        在庫が残っているかチェック
        if (stockProduct.quantity < 1) {
            return false
        }
//        投入金額が足りているかチェック
        var coinBox: CoinBox = coinBoxService.findAll()
        if (stockProduct.price > coinBox.deposit) {
            return false
        }

//        投入金額を減らす
        coinBox.deposit -= stockProduct.price
//        一度でも購入すると投入した各お金は0として扱う
        coinBox.deposit10 = 0
        coinBox.deposit50 = 0
        coinBox.deposit100 = 0
        coinBox.deposit500 = 0
        coinBox.deposit1000 = 0

        coinBoxService.update(coinBox)
//        在庫を減らす
        var stock: Stock = stockService.findById(id)
        stock.quantity -= 1
        stockService.update(stock)
        //        購入履歴を更新
        var history =
            SalesHistory(
                id = UUID.randomUUID().toString(),
                purchaseTime = LocalDateTime.now(),
                productId = stockService.findById(id).id
            )
        salesHistoryService.create(history)
        return true
    }
}