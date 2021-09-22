package app.vendingmachine.controller

import app.vendingmachine.model.Product
import app.vendingmachine.service.ProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/product")
class ProductController @Autowired constructor(val productService: ProductService) {

    @GetMapping("")
    fun findAll(): List<Product> {
        return productService.findAll()
    }

    @PostMapping("")
    fun create(@RequestBody product: Product): Boolean {
        return productService.create(product)
    }

    @PutMapping("")
    fun update(@RequestBody product: Product): Boolean {
        return productService.update(product)
    }

    @DeleteMapping("")
    fun delete(@RequestBody id: String): Boolean {
        return productService.delete(id)
    }
}