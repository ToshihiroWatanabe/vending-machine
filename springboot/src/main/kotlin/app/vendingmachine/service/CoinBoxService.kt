package app.vendingmachine.service

import app.vendingmachine.mapper.CoinBoxMapper
import app.vendingmachine.model.CoinBox
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CoinBoxService @Autowired constructor(val coinBoxMapper: CoinBoxMapper) {

    fun findAll(): CoinBox {
        return coinBoxMapper.findAll()
    }

    fun update(coinBox: CoinBox): Boolean {
        return coinBoxMapper.update(coinBox)
    }

    /**
     * お金を投入します。
     */
    fun insert(value: Int): CoinBox {
        val coinBox: CoinBox = coinBoxMapper.findAll()
        if (coinBox.deposit + value > 9999) {
            return coinBoxMapper.findAll()
        }
        when (value) {
            10 -> {
                if (coinBox.left10 >= 999) {
                    return return coinBoxMapper.findAll()
                }
                coinBoxMapper.insert10()
            }
            50 -> {
                if (coinBox.left50 >= 999) {
                    return return coinBoxMapper.findAll()
                }
                coinBoxMapper.insert50()
            }
            100 -> {
                if (coinBox.left100 >= 999) {
                    return return coinBoxMapper.findAll()
                }
                coinBoxMapper.insert100()
            }
            500 -> {
                if (coinBox.left500 >= 999) {
                    return return coinBoxMapper.findAll()
                }
                coinBoxMapper.insert500()
            }
            1000 -> {
                if (coinBox.left1000 >= 999) {
                    return return coinBoxMapper.findAll()
                }
                coinBoxMapper.insert1000()
            }
        }
        return coinBoxMapper.findAll()
    }

    /**
     * お釣りを返却します。
     */
    fun release(): Boolean {
        return coinBoxMapper.release()
    }
}
