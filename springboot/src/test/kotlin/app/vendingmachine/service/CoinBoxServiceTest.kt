package app.vendingmachine.service

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
@DisplayName("CoinBoxServiceのテスト")
class CoinBoxServiceTest {
    @Autowired
    lateinit var coinBoxService: CoinBoxService

}