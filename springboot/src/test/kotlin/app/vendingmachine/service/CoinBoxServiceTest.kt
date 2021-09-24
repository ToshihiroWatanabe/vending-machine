package app.vendingmachine.service

import app.vendingmachine.mapper.CoinBoxMapper
import app.vendingmachine.model.CoinBox
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Disabled
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
    @DisplayName("updateのテスト")
    inner class Update {
        @Test
        @DisplayName("trueが返る事")
        fun returnTrue() {
            val coinBox = CoinBox(1660, 1, 1, 1, 1, 1, 120, 120, 120, 120, 120)
            given(mockCoinBoxMapper.update(coinBox)).willReturn(true)
            assertEquals(true, coinBoxService.update(coinBox))
        }

        @Test
        @DisplayName("falseが返る事")
        fun returnFalse() {
            val coinBox = CoinBox(1660, 1, 1, 1, 1, 1, 120, 120, 120, 120, 120)
            given(mockCoinBoxMapper.update(coinBox)).willReturn(false)
            assertEquals(false, coinBoxService.update(coinBox))
        }
    }

    @Nested
    @DisplayName("insertのテスト")
    inner class Insert {
        @Test
        @Disabled
        @DisplayName("投入金額が9990円のときに10円玉を投入できないこと")
        fun insert10Deposit9990() {
            val deposit9990coinBox = CoinBox(9990, 4, 1, 4, 1, 9, 100, 50, 50, 50, 0)
            given(mockCoinBoxMapper.findAll()).willReturn(deposit9990coinBox)
            assertEquals(deposit9990coinBox, coinBoxService.insert(10))
        }
    }

    @Nested
    @DisplayName("releaseのテスト")
    inner class Release {
        @Test
        @Disabled
        @DisplayName("投入金額と投入したお金の枚数が全て0になって返る事")
        fun deposit0() {
            val coinBox = CoinBox(1660, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1)

            given(mockCoinBoxMapper.findAll()).willReturn(coinBox)
            assertEquals(0, 1)
        }
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

    @Nested
    @DisplayName("adjustのテスト")
    inner class Adjust {
        @Test
        @Disabled
        @DisplayName("10円玉の調整")
        fun adjust10() {

        }
    }
}