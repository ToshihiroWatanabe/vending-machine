package app.vendingmachine.controller

import app.vendingmachine.model.CoinBox
import app.vendingmachine.service.CoinBoxService
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.mockito.BDDMockito.given
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath

@WebMvcTest
@DisplayName("CoinBoxControllerのテスト")
internal class CoinBoxControllerTest {
    @Autowired
    lateinit var mockMvc: MockMvc

    @MockBean
    lateinit var mockCoinBoxService: CoinBoxService

    @Nested
    @DisplayName("FindAll")
    inner class FindAll{

        @DisplayName("findAll")
        @Test
        fun findAll(){
            given(mockCoinBoxService.findAll()).willReturn(CoinBox(100,120,120,120,120,120))
            mockMvc.perform(get("/api/coin-box"))
                .andExpect(status().isOk)
                .andExpect(jsonPath("deposit").value(100))
                .andExpect(jsonPath("left10").value(120))
                .andExpect(jsonPath("left50").value(120))
                .andExpect(jsonPath("left100").value(120))
                .andExpect(jsonPath("left500").value(120))
                .andExpect(jsonPath("left1000").value(120))
        }
    }
}