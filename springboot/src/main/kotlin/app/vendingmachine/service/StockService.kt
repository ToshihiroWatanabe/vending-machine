package app.vendingmachine.service

import app.vendingmachine.mapper.StockMapper
import app.vendingmachine.model.Stock
import app.vendingmachine.model.StockResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class StockService @Autowired constructor(val stockMapper: StockMapper) {

    fun findAll(): List<Stock> {
        return stockMapper.findAll()
    }

    fun findAllStockProducts(): List<StockResponse> {
        return stockMapper.findAllStockProducts()
    }

    fun findById(id: Int): Stock {
        return stockMapper.findById(id)
    }

    fun findStockProductById(id: Int): StockResponse {
        return stockMapper.findStockProductById(id)
    }

    fun create(stock: Stock): Boolean {
        return stockMapper.create(stock)
    }

    fun update(stock: Stock): Boolean {
        return stockMapper.update(stock)
    }

    fun delete(id: Int): Boolean {
        return stockMapper.delete(id)
    }

    /**
     * 在庫を補充します。
     * @param id 在庫ID
     * @param increment 増分
     */
    fun supply(id: Int, increment: Int): Boolean {
        var stock: Stock = stockMapper.findById(id)
        stock.quantity += increment
        return stockMapper.update(stock)
    }
}