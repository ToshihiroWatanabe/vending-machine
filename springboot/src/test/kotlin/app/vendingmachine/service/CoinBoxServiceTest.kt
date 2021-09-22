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

    @Nested
    @DisplayName("CalcChangeのテスト")
    inner class CalcChange {
        @Test
        fun calcChange1000() {
            val array: Array<Int> = arrayOf(1, 0, 0, 0, 0, 0)
            assertArrayEquals(array, coinBoxService.calcChange(1000))
        }

        @Test
        fun calcChange500() {
            val array: Array<Int> = arrayOf(0, 1, 0, 0, 0, 0)
            assertArrayEquals(array, coinBoxService.calcChange(500))
        }
    }
}