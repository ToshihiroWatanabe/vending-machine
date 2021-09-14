package app.vendingmachine.controller

import app.vendingmachine.mapper.CoinBoxMapper
import app.vendingmachine.model.CoinBox
import app.vendingmachine.service.CoinBoxService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/coin-box")
class CoinBoxController(val coinBoxService: CoinBoxService, val coinBoxMapper: CoinBoxMapper) {

    @GetMapping("")
    fun findAll():CoinBox{
        return coinBoxMapper.findAll()
    }

    @PutMapping("")
    fun update(coinBox: CoinBox):Boolean{
        return coinBoxMapper.update(coinBox)
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
        var coinBox = coinBoxMapper.findAll()
        val coinCount: Array<Int> = coinBoxService.calcChange(coinBox.deposit)
        coinBox.deposit = 0
        coinBox.left1000 -= coinCount[1]
        coinBox.left500 -= coinCount[2]
        coinBox.left100 -= coinCount[3]
        coinBox.left50 -= coinCount[4]
        coinBox.left10 -= coinCount[5]
        coinBoxMapper.update(coinBox)
        return coinBoxMapper.findAll()
    }
}