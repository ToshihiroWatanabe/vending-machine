package app.vendingmachine.service

import app.vendingmachine.mapper.ProductMapper
import app.vendingmachine.model.Product
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ProductService @Autowired constructor(val productMapper: ProductMapper) {

    fun findAll(): List<Product> {
        return productMapper.findAll()
    }

    fun create(product: Product): Boolean {
        return productMapper.create(product)
    }

    fun update(product: Product): Boolean {
        return productMapper.update(product)
    }

    fun delete(id: String): Boolean {
        return productMapper.delete(id)
    }
}