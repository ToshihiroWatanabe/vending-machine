package app.vendingmachine.mapper

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace
import org.springframework.context.annotation.Import

@MybatisTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Import(CoinBoxMapper::class)
@DisplayName("CoinBoxテーブルのマッパークラスのテスト")
class CoinBoxMapperTest() {


    @Test
    fun pass() {
        assertEquals(0, 0)
    }

//    @Test
//    @ParameterizedTest
//    fun 投入金額を取得できる事(){
//        assertEquals(0, coinBoxMapper.findAll().deposit)
//    }
}