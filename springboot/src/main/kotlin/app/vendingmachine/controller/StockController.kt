package app.vendingmachine.controller

import app.vendingmachine.model.Stock
import app.vendingmachine.model.StockResponse
import app.vendingmachine.service.StockService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

/**
 * 在庫テーブルに関するコントローラークラスです。
 */
@RestController
@RequestMapping("/api/stock")
class StockController @Autowired constructor(val stockService: StockService) {

    /**
     * 在庫データを全件取得します。
     */
    @GetMapping("")
    fun findAll(): List<StockResponse> {
        return stockService.findAllStockProducts()
    }

    /**
     * 新しい在庫データを追加します。
     */
    @PostMapping("")
    fun create(@RequestBody stock: Stock): Boolean {
        return stockService.create(stock)
    }

    /**
     * 在庫データを更新します。
     */
    @PutMapping("")
    fun update(@RequestBody stock: Stock): Boolean {
        return stockService.update(stock)
    }

    /**
     * 指定されたIDの在庫データを削除します。
     */
    @DeleteMapping("")
    fun delete(@RequestBody id: Int): Boolean {
        return stockService.delete(id)
    }

    /**
     * 在庫を補充します。
     * @param id 在庫ID
     * @param increment 増分
     */
    @PostMapping("/supply/{id}")
    fun supply(@PathVariable id: Int, @RequestBody increment: Int): Boolean {
        return stockService.supply(id, increment)
    }
}