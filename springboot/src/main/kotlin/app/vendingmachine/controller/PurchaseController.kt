package app.vendingmachine.controller

import app.vendingmachine.service.PurchaseService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiParam
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Api(tags = ["purchase"], description = "商品の購入に関するAPIです。")
@RestController
@RequestMapping("/api/purchase")
class PurchaseController @Autowired constructor(val purchaseService: PurchaseService) {

    @ApiOperation(value = "商品購入", notes = "指定された在庫IDの商品を購入します。")
    @PostMapping("/{id}")
    fun purchase(@ApiParam(value = "在庫ID", example = "1") @PathVariable id: Int): Boolean {
        return purchaseService.purchase(id)
    }
}