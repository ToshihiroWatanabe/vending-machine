package app.vendingmachine.mapper

import app.vendingmachine.model.CoinBox
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Select
import org.apache.ibatis.annotations.Update

@Mapper
interface CoinBoxMapper {

    @Select("""
        SELECT * FROM coin_box
    """)
    fun findAll():CoinBox

    @Update("""
        UPDATE coin_box
        SET deposit=#{deposit},
            left_10=#{left10},
            left_50=#{left50},
            left_100=#{left100},
            left_500=#{left500},
            left_1000=#{left1000}
        WHERE id=0
    """)
    fun update(coinBox: CoinBox):Boolean
}