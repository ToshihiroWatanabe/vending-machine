package app.vendingmachine.controller

import app.vendingmachine.model.SalesHistory
import app.vendingmachine.service.SalesHistoryService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

/**
 * 販売履歴テーブルに関するコントローラークラスです。
 */
@RestController
@RequestMapping("/api/sales-history")
class SalesHistoryController @Autowired constructor(val salesHistoryService: SalesHistoryService) {

    /**
     * 販売履歴を全件取得します。
     */
    @GetMapping("")
    fun findAll(): List<SalesHistory> {
        return salesHistoryService.findAll()
    }

    /**
     * 販売履歴に新しく追加します。
     */
    @PostMapping("")
    fun create(@RequestBody salesHistory: SalesHistory): Boolean {
        return salesHistoryService.create(salesHistory)
    }

    /**
     * 販売履歴を更新します。
     */
    @PutMapping("")
    fun update(@RequestBody salesHistory: SalesHistory): Boolean {
        return salesHistoryService.update(salesHistory)
    }

    /**
     * 販売履歴から指定されたIDのデータを削除します。
     */
    @DeleteMapping("")
    fun delete(@RequestBody id: String): Boolean {
        return salesHistoryService.delete(id)
    }

    /**
     * 全ての販売履歴を削除します。
     */
    @DeleteMapping("/delete-all")
    fun deleteAll(): Boolean {
        return salesHistoryService.deleteAll()
    }
}