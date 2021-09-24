package app.vendingmachine.controller

import app.vendingmachine.model.CoinBox
import app.vendingmachine.service.CoinBoxService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

/**
 * 投入金額とお釣り用のお金に関するコントローラークラスです。
 */
@RestController
@RequestMapping("/api/coin-box")
class CoinBoxController @Autowired constructor(val coinBoxService: CoinBoxService) {

    /**
     * お金のデータを取得します。
     */
    @GetMapping("")
    fun findAll(): CoinBox {
        return coinBoxService.findAll()
    }

    /**
     * お金のデータを更新します。
     */
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

    /**
     * 指定されたお金の残り枚数を調整します。
     */
    @PostMapping("/adjust/{money}")
    fun adjust(@PathVariable money: Int): CoinBox {
        return coinBoxService.adjust(money)
    }

    /**
     * 指定されたお金を回収します。
     */
    @PostMapping("/withdraw/{money}")
    fun withdraw(@PathVariable money: Int): CoinBox {
        return coinBoxService.withdraw(money)
    }
}