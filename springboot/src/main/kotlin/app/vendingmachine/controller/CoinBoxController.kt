package app.vendingmachine.controller

import app.vendingmachine.mapper.CoinBoxMapper
import app.vendingmachine.model.CoinBox
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/coin-box")
class CoinBoxController(val coinBoxMapper: CoinBoxMapper) {

    @GetMapping("")
    fun findAll():CoinBox{
        return coinBoxMapper.findAll()
    }

    @PutMapping("")
    fun update(coinBox: CoinBox):Boolean{
        return coinBoxMapper.update(coinBox)
    }

}