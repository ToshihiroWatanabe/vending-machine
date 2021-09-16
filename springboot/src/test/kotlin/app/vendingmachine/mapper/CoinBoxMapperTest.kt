package app.vendingmachine.mapper

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest
import org.springframework.test.context.TestPropertySource

@MybatisTest
@TestPropertySource(locations = ["classpath:test.properties"])
@DisplayName("CoinBoxテーブルのマッパークラスのテスト")
class CoinBoxMapperTest(val coinBoxMapper: CoinBoxMapper) {

    @Test
    fun pass(){
        assertEquals(0,0)
    }

//    @Test
//    @ParameterizedTest
//    fun 投入金額を取得できる事(){
//        assertEquals(0, coinBoxMapper.findAll().deposit)
//    }
}