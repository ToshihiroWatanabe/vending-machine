package app.vendingmachine.controller

import app.vendingmachine.model.Stock
import app.vendingmachine.model.StockResponse
import app.vendingmachine.service.StockService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiParam
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@Api(tags = ["stock"], description = "在庫に関するAPIです。")
@RestController
@RequestMapping("/api/stock")
class StockController @Autowired constructor(val stockService: StockService) {

    @ApiOperation(value = "在庫データ全件取得", notes = "在庫データを全件取得します。")
    @GetMapping("")
    fun findAll(): List<StockResponse> {
        return stockService.findAllStockProducts()
    }

    @ApiOperation(value = "在庫データ追加", notes = "新しい在庫データを追加します。")
    @PostMapping("")
    fun create(@ApiParam(value = "追加する在庫データ", required = true) @RequestBody stock: Stock): Boolean {
        return stockService.create(stock)
    }

    @ApiOperation(value = "在庫データ更新", notes = "在庫データを更新します。")
    @PutMapping("")
    fun update(@ApiParam(value = "更新する在庫データ", required = true) @RequestBody stock: Stock): Boolean {
        return stockService.update(stock)
    }

    @ApiOperation(value = "在庫データ削除", notes = "指定されたIDの在庫データを削除します。")
    @DeleteMapping("")
    fun delete(@ApiParam(value = "削除する在庫データのID", required = true) @RequestBody id: Int): Boolean {
        return stockService.delete(id)
    }

    @ApiOperation(value = "在庫補充", notes = "在庫を補充します。")
    @PostMapping("/supply/{id}")
    fun supply(@ApiParam(value = "在庫ID", required = true) @PathVariable id: Int, @ApiParam(value = "増分", required = true) @RequestBody increment: Int): Boolean {
        return stockService.supply(id, increment)
    }
}