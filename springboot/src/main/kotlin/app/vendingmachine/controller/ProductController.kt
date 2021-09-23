package app.vendingmachine.controller

import app.vendingmachine.model.Product
import app.vendingmachine.service.ProductService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

/**
 * 商品テーブルに関するコントローラークラスです。
 */
@RestController
@RequestMapping("/api/product")
class ProductController @Autowired constructor(val productService: ProductService) {

    /**
     * 商品テーブルのデータを全件取得します。
     */
    @GetMapping("")
    fun findAll(): List<Product> {
        return productService.findAll()
    }

    /**
     * 新しい商品データを追加します。
     */
    @PostMapping("")
    fun create(@RequestBody product: Product): Boolean {
        return productService.create(product)
    }

    /**
     * 商品データを更新します。
     */
    @PutMapping("")
    fun update(@RequestBody product: Product): Boolean {
        return productService.update(product)
    }

    /**
     * 指定されたIDの商品データを削除します。
     */
    @DeleteMapping("")
    fun delete(@RequestBody id: String): Boolean {
        return productService.delete(id)
    }
}