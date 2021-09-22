package app.vendingmachine.mapper

import app.vendingmachine.model.Stock
import app.vendingmachine.model.StockResponse
import org.apache.ibatis.annotations.*

@Mapper
interface StockMapper {

    @Select(
        """
        select * from stocks
    """
    )
    fun findAll(): List<Stock>

    @Select(
        """
        select stocks.id, name, temperature, price, quantity from stocks
        join products on stocks.product_id = products.id
    """
    )
    fun findAllStockProducts(): List<StockResponse>

    @Select(
        """
            select * from stocks where id = #{id}
        """
    )
    fun findById(id: Int): Stock

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