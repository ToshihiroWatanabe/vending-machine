package app.vendingmachine.controller

import app.vendingmachine.service.PurchaseService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/purchase")
class PurchaseController @Autowired constructor(val purchaseService: PurchaseService) {

    @PostMapping("/{id}")
    fun purchase(@PathVariable id: Int): Boolean {
        return purchaseService.purchase(id)
    }
}