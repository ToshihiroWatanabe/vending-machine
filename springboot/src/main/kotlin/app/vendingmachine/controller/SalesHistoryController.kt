package app.vendingmachine.controller

import app.vendingmachine.model.SalesHistory
import app.vendingmachine.service.SalesHistoryService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiParam
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@Api(tags = ["sales-history"], description = "販売履歴に関するAPIです。")
@RestController
@RequestMapping("/api/sales-history")
class SalesHistoryController @Autowired constructor(val salesHistoryService: SalesHistoryService) {

    @ApiOperation(value = "販売履歴全件取得", notes = "販売履歴を全件取得します。")
    @GetMapping("")
    fun findAll(): List<SalesHistory> {
        return salesHistoryService.findAll()
    }

    @ApiOperation(value = "販売履歴新規追加", notes = "販売履歴に新しく追加します。")
    @PostMapping("")
    fun create(@ApiParam(value = "追加する販売履歴", required = true) @RequestBody salesHistory: SalesHistory): Boolean {
        return salesHistoryService.create(salesHistory)
    }

    @ApiOperation(value = "販売履歴更新", notes = "既存の販売履歴を更新します。")
    @PutMapping("")
    fun update(@ApiParam(value = "更新する販売履歴", required = true) @RequestBody salesHistory: SalesHistory): Boolean {
        return salesHistoryService.update(salesHistory)
    }

    @ApiOperation(value = "販売履歴削除", notes = "販売履歴から指定されたIDのデータを削除します。")
    @DeleteMapping("")
    fun delete(@ApiParam(value = "削除する販売履歴のID", required = true) @RequestBody id: String): Boolean {
        return salesHistoryService.delete(id)
    }

    @ApiOperation(value = "販売履歴全件削除", notes = "全ての販売履歴を削除します。")
    @DeleteMapping("/delete-all")
    fun deleteAll(): Boolean {
        return salesHistoryService.deleteAll()
    }
}