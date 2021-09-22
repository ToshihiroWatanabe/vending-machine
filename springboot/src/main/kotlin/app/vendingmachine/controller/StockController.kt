package app.vendingmachine.controller

import app.vendingmachine.model.Stock
import app.vendingmachine.model.StockResponse
import app.vendingmachine.service.StockService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/stock")
class StockController @Autowired constructor(val stockService: StockService) {

    @GetMapping("")
    fun findAll(): List<StockResponse> {
        return stockService.findAllStockProducts()
    }

    @PostMapping("")
    fun create(@RequestBody stock: Stock): Boolean {
        return stockService.create(stock)
    }

    @PutMapping("")
    fun update(@RequestBody stock: Stock): Boolean {
        return stockService.update(stock)
    }

    @DeleteMapping("")
    fun delete(@RequestBody id: Int): Boolean {
        return stockService.delete(id)
    }
}