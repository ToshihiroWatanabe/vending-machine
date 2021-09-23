package app.vendingmachine.mapper

import app.vendingmachine.model.SalesHistory
import org.apache.ibatis.annotations.*

@Mapper
interface SalesHistoryMapper {

    @Select(
        """
        select * from sales_history
    """
    )
    fun findAll(): List<SalesHistory>

    @Insert(
        """
        insert into sales_history (id, purchase_time, product_id) values (#{id}, #{purchaseTime}, #{productId})
    """
    )
    fun create(salesHistory: SalesHistory): Boolean

    @Update(
        """
        update sales_history set purchase_time = #{purchaseTime}, product_id = #{productId}
        where id = #{id}
    """
    )
    fun update(salesHistory: SalesHistory): Boolean

    @Delete(
        """
        delete from sales_history
        where id = #{id}
    """
    )
    fun delete(id: String): Boolean

    @Delete(
        """
            delete from sales_history
        """
    )
    fun deleteAll(): Boolean
}