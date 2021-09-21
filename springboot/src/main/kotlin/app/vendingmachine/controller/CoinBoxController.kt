package app.vendingmachine.controller

import app.vendingmachine.model.CoinBox
import app.vendingmachine.service.CoinBoxService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/coin-box")
class CoinBoxController @Autowired constructor(val coinBoxService: CoinBoxService) {

    @GetMapping("")
    fun findAll():CoinBox{
        return coinBoxService.findAll()
    }

    @PutMapping("")
    fun update(@RequestBody coinBox: CoinBox):Boolean{
        return coinBoxService.update(coinBox)
    }

    /**
     * お金を投入します。
     */
    @PatchMapping("/insert/{value}")
    fun insert(@PathVariable value: Int):CoinBox{
        return coinBoxService.insert(value)
    }

    /**
     * お釣りを返却します。
     */
    @PatchMapping("/release")
    fun release(): CoinBox{
        var coinBox = coinBoxService.findAll()
        val coinCount: Array<Int> = coinBoxService.calcChange(coinBox.deposit)
        coinBox.deposit = 0
        coinBox.left1000 -= coinCount[1]
        coinBox.left500 -= coinCount[2]
        coinBox.left100 -= coinCount[3]
        coinBox.left50 -= coinCount[4]
        coinBox.left10 -= coinCount[5]
        coinBoxService.update(coinBox)
        return coinBoxService.findAll()
    }
}