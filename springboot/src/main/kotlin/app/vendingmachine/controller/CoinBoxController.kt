package app.vendingmachine.controller

import app.vendingmachine.model.CoinBox
import app.vendingmachine.service.CoinBoxService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiParam
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@Api(tags = ["coin-box"], description = "投入金額とお釣り用のお金に関するAPIです。")
@RestController
@RequestMapping("/api/coin-box")
class CoinBoxController @Autowired constructor(val coinBoxService: CoinBoxService) {

    @ApiOperation(value = "お金データ取得", notes = "お金のデータを取得します。")
    @GetMapping("")
    fun findAll(): CoinBox {
        return coinBoxService.findAll()
    }

    @ApiOperation(value = "お金データ更新", notes = "お金のデータを更新します。")
    @PutMapping("")
    fun update(@ApiParam(value = "更新するお金データ", required = true) @RequestBody coinBox: CoinBox): Boolean {
        return coinBoxService.update(coinBox)
    }

    @ApiOperation(value = "お金投入", notes = "お金を投入します。")
    @PatchMapping("/insert/{value}")
    fun insert(@ApiParam(value = "投入するお金",required = true, example = "100") @PathVariable value: Int): CoinBox {
        return coinBoxService.insert(value)
    }

    @ApiOperation(value = "お釣り返却", notes = "お釣りを返却します。")
    @PatchMapping("/release")
    fun release(): CoinBox {
        coinBoxService.release()
        return coinBoxService.findAll()
    }

    @ApiOperation(value = "残り枚数調整", notes = "指定されたお金の残り枚数を調整します。")
    @PostMapping("/adjust/{money}")
    fun adjust(@ApiParam(value = "調整するお金", required = true, example = "10") @PathVariable money: Int): CoinBox {
        return coinBoxService.adjust(money)
    }

    @ApiOperation(value = "お金回収", notes = "指定されたお金を回収します。")
    @PostMapping("/withdraw/{money}")
    fun withdraw(@ApiParam(value = "回収するお金", required = true, example = "1000") @PathVariable money: Int): CoinBox {
        return coinBoxService.withdraw(money)
    }
}
