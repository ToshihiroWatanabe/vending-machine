package app.vendingmachine.service

import app.vendingmachine.mapper.CoinBoxMapper
import app.vendingmachine.model.CoinBox
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.mockito.BDDMockito.given

@SpringBootTest
@DisplayName("CoinBoxServiceのテスト")
class CoinBoxServiceTest {
    @Autowired
    lateinit var coinBoxService: CoinBoxService

    @MockBean
    lateinit var mockCoinBoxMapper: CoinBoxMapper

    @Test
    @DisplayName("findAllのテスト")
    fun findAll() {
        given(mockCoinBoxMapper.findAll()).willReturn(
            CoinBox(1660, 1, 1, 1, 1, 1, 120, 120, 120, 120, 120)
        )
        assertEquals(CoinBox(1660, 1, 1, 1, 1, 1, 120, 120, 120, 120, 120), coinBoxService.findAll())
    }

    @Nested
    @DisplayName("calcChangeのテスト")
    inner class CalcChange {
        @Test
        @DisplayName("1000円を返却すると1000円札が1枚返る事")
        fun calcChange1000() {
            val array: Array<Int> = arrayOf(1, 0, 0, 0, 0)
            assertArrayEquals(array, coinBoxService.calcChange(1000))
        }

        @Test
        @DisplayName("500円を返却すると500円玉が1枚返る事")
        fun calcChange500() {
            val array: Array<Int> = arrayOf(0, 1, 0, 0, 0)
            assertArrayEquals(array, coinBoxService.calcChange(500))
        }

        @Test
        @DisplayName("1660円を返却すると1000円札、500円玉、100円玉、50円玉、10円玉がそれぞれ1枚ずつ返る事")
        fun calcChange1660() {
            val array: Array<Int> = arrayOf(1, 1, 1, 1, 1)
            assertArrayEquals(array, coinBoxService.calcChange(1660))
        }
    }
}