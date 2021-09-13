package app.vendingmachine.mapper

import app.vendingmachine.model.CoinBox
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Select

@Mapper
interface CoinBoxMapper {

    @Select("""
        SELECT * FROM coin_box
    """)
    fun findAll():CoinBox
}