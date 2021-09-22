package app.vendingmachine.service

import app.vendingmachine.mapper.StockMapper
import app.vendingmachine.model.Stock
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class StockService @Autowired constructor(val stockMapper: StockMapper) {

    fun findAll(): List<Stock> {
        return stockMapper.findAll()
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
}