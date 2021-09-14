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
        SET deposit = #{deposit},
            left_10 = #{left10},
            left_50 = #{left50},
            left_100 = #{left100},
            left_500 = #{left500},
            left_1000 = #{left1000}
        WHERE id = 0
    """)
    fun update(coinBox: CoinBox):Boolean

    @Update("""
        UPDATE coin_box
        SET deposit = deposit + 10,
            left_10 = left_10 + 1
        WHERE id = 0
    """)
    fun insert10():Boolean

    @Update("""
        UPDATE coin_box
        SET deposit = deposit + 50,
            left_50 = left_50 + 1
        WHERE id = 0
    """)
    fun insert50():Boolean

    @Update("""
        UPDATE coin_box
        SET deposit = deposit + 100,
            left_100 = left_100 + 1
        WHERE id = 0
    """)
    fun insert100():Boolean

    @Update("""
        UPDATE coin_box
        SET deposit = deposit + 500,
            left_500 = left_500 + 1
        WHERE id = 0
    """)
    fun insert500():Boolean

    @Update("""
        UPDATE coin_box
        SET deposit = deposit + 1000,
            left_1000 = left_1000 + 1
        WHERE id = 0
    """)
    fun insert1000():Boolean

}