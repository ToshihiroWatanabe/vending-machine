package app.vendingmachine.mapper

import app.vendingmachine.model.Stock
import org.apache.ibatis.annotations.*

@Mapper
interface StockMapper {

    @Select(
        """
        select * from stocks
    """
    )
    fun findAll(): List<Stock>

    @Insert(
        """
        insert into stocks (id, product_id, quantity)
        values (#{id}, #{productId}, #{quantity})
    """
    )
    fun create(stock: Stock): Boolean

    @Update(
        """
        update stocks set product_id = #{productId}, quantity = #{quantity}
        where id = #{id}
    """
    )
    fun update(stock: Stock): Boolean

    @Delete(
        """
        delete from stocks where id = #{id}
    """
    )
    fun delete(id: Int): Boolean
}