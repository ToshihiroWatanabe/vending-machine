package app.vendingmachine.service

import app.vendingmachine.model.Stock
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.Objects.isNull

@Service
class PurchaseService @Autowired constructor(val stockService: StockService) {

    fun purchase(id: Int): Boolean {
//        指定されたIDのstockが存在するかチェック
        var stock: Stock = stockService.findById(id)
        if (isNull(stock)) {
            return false
        }
        return true
//        投入金額が足りているかチェック

    }
}