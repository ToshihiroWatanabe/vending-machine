package app.vendingmachine.service

import app.vendingmachine.mapper.CoinBoxMapper
import app.vendingmachine.model.CoinBox
import org.springframework.stereotype.Service

@Service
class CoinBoxService(val coinBoxMapper: CoinBoxMapper) {

    /**
     * お金を投入します。
     */
    fun insert(value: Int):CoinBox{
        when (value) {
            10 -> {
                coinBoxMapper.insert10()
            }
            50 -> {
                coinBoxMapper.insert50()
            }
            100 -> {
                coinBoxMapper.insert100()
            }
            500 -> {
                coinBoxMapper.insert500()
            }
            1000 -> {
                coinBoxMapper.insert1000()
            }
        }
        return coinBoxMapper.findAll()
    }

    /**
     * お釣りの金額から硬貨や紙幣の枚数を計算します。
     */
    fun calcChange(change: Int):Array<Int>{
        val moneyList = listOf(1000, 500, 200, 100, 50, 10)
        var moneyCount: Array<Int> = arrayOf()
        var changeLeft = change
        moneyList.forEach{money ->
            val changeMoney = changeLeft / money
            moneyCount += changeMoney
            changeLeft %= money
        }
        return moneyCount
    }
}