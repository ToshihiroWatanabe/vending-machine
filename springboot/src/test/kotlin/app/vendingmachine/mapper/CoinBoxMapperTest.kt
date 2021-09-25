package app.vendingmachine.mapper

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace
import org.springframework.test.context.DynamicPropertyRegistry
import org.springframework.test.context.DynamicPropertySource
import org.testcontainers.containers.MySQLContainer
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.utility.DockerImageName

@MybatisTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@DisplayName("CoinBoxテーブルのマッパークラスのテスト")
class CoinBoxMapperTest() {

    companion object {
        @Container
        @JvmStatic
        val mysql = MySQLContainer<Nothing>(DockerImageName.parse("mysql:8.0")).apply {
            withDatabaseName("vending_machine_db_test")
            withUsername("root")
            withPassword("root")
            withInitScript("../../resources/schema.sql")
            withInitScript("../../resources/data.sql")
        }

        @DynamicPropertySource
        @JvmStatic
        fun setUp(registry: DynamicPropertyRegistry) {
            registry.add("spring.datasource.url", mysql::getJdbcUrl)
            registry.add("spring.datasource.username", mysql::getUsername)
            registry.add("spring.datasource.password", mysql::getPassword)
        }
    }

    @Autowired
    private lateinit var coinBoxMapper: CoinBoxMapper

    @Test
    fun findAll() {
        val coinBox = coinBoxMapper.findAll()
        assertEquals(100, coinBox.deposit10)
    }
}