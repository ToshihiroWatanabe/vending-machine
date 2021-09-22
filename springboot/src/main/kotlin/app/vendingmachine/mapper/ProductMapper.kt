package app.vendingmachine.mapper

import app.vendingmachine.model.Product
import org.apache.ibatis.annotations.*

@Mapper
interface ProductMapper {

    @Select(
        """
        select * from products
    """
    )
    fun findAll(): List<Product>

    @Insert(
        """
        insert into products (id, name, temperature, price, vendor_name)
        values (#{id}, #{name}, #{temperature}, #{price}, #{vendorName})
    """
    )
    fun create(product: Product): Boolean

    @Update(
        """
        update products set name = #{name}, temperature = #{temperature}, price = #{price}, vendor_name = #{vendorName}
        where id = #{id}
    """
    )
    fun update(product: Product): Boolean

    @Delete(
        """
        delete from products where id = #{id}
    """
    )
    fun delete(id: String): Boolean
}