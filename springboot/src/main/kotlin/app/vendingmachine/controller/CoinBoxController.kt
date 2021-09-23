package app.vendingmachine.controller

import app.vendingmachine.model.CoinBox
import app.vendingmachine.service.CoinBoxService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/coin-box")
class CoinBoxController @Autowired constructor(val coinBoxService: CoinBoxService) {

    @GetMapping("")
    fun findAll(): CoinBox {
        return coinBoxService.findAll()
    }

    @PutMapping("")
    fun update(@RequestBody coinBox: CoinBox): Boolean {
        return coinBoxService.update(coinBox)
    }

    /**
     * お金を投入します。
     */
    @PatchMapping("/insert/{value}")
    fun insert(@PathVariable value: Int): CoinBox {
        return coinBoxService.insert(value)
    }

    /**
     * お釣りを返却します。
     */
    @PatchMapping("/release")
    fun release(): CoinBox {
        coinBoxService.release()
        return coinBoxService.findAll()
    }
}