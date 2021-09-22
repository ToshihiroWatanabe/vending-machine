package app.vendingmachine.controller

import app.vendingmachine.model.SalesHistory
import app.vendingmachine.service.SalesHistoryService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/sales-history")
class SalesHistoryController @Autowired constructor(val salesHistoryService: SalesHistoryService) {

    @GetMapping("")
    fun findAll(): List<SalesHistory> {
        return salesHistoryService.findAll()
    }

    @PostMapping("")
    fun create(@RequestBody salesHistory: SalesHistory): Boolean {
        return salesHistoryService.create(salesHistory)
    }

    @PutMapping("")
    fun update(@RequestBody salesHistory: SalesHistory): Boolean {
        return salesHistoryService.update(salesHistory)
    }

    @DeleteMapping("")
    fun delete(@RequestBody id: String): Boolean {
        return salesHistoryService.delete(id)
    }
}