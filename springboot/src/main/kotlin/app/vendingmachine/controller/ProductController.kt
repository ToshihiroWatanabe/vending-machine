package app.vendingmachine.controller

import app.vendingmachine.model.Product
import app.vendingmachine.service.ProductService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiParam
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@Api(tags = ["product"], description = "商品に関するAPIです。")
@RestController
@RequestMapping("/api/product")
class ProductController @Autowired constructor(val productService: ProductService) {

    @ApiOperation(value = "商品データ全件取得", notes = "商品テーブルのデータを全件取得します。")
    @GetMapping("")
    fun findAll(): List<Product> {
        return productService.findAll()
    }

    @ApiOperation(value = "商品データ追加", notes = "新しい商品データを追加します。")
    @PostMapping("")
    fun create(@ApiParam(value = "追加する商品データ", required = true) @RequestBody product: Product): Boolean {
        return productService.create(product)
    }

    @ApiOperation(value = "商品データ更新", notes = "商品データを更新します。")
    @PutMapping("")
    fun update(@ApiParam(value = "更新する商品データ", required = true) @RequestBody product: Product): Boolean {
        return productService.update(product)
    }

    @ApiOperation(value = "商品データ削除", notes = "指定されたIDの商品データを削除します。")
    @DeleteMapping("")
    fun delete(@ApiParam(value = "削除する商品のID") @RequestBody id: String): Boolean {
        return productService.delete(id)
    }
}