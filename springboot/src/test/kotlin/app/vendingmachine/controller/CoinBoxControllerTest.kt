package app.vendingmachine.controller

import app.vendingmachine.model.CoinBox
import app.vendingmachine.service.CoinBoxService
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.mockito.BDDMockito.given
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

@WebMvcTest(CoinBoxController::class)
@DisplayName("CoinBoxControllerのテスト")
internal class CoinBoxControllerTest {
    @Autowired
    lateinit var mockMvc: MockMvc

    @Autowired
    lateinit var mapper: ObjectMapper

    @MockBean
    lateinit var mockCoinBoxService: CoinBoxService

    @Nested
    @DisplayName("findAllのテスト")
    inner class FindAll {

        @Test
        @DisplayName("GETリクエストのレスポンスが返る事")
        fun findAll() {
            given(mockCoinBoxService.findAll()).willReturn(CoinBox(1660, 1, 1, 1, 1, 1, 120, 120, 120, 120, 120))
            mockMvc.perform(get("/api/coin-box"))
                .andExpect(status().isOk)
                .andExpect(jsonPath("deposit").value(1660))
                .andExpect(jsonPath("deposit10").value(1))
                .andExpect(jsonPath("deposit50").value(1))
                .andExpect(jsonPath("deposit100").value(1))
                .andExpect(jsonPath("deposit500").value(1))
                .andExpect(jsonPath("deposit1000").value(1))
                .andExpect(jsonPath("left10").value(120))
                .andExpect(jsonPath("left50").value(120))
                .andExpect(jsonPath("left100").value(120))
                .andExpect(jsonPath("left500").value(120))
                .andExpect(jsonPath("left1000").value(120))
        }
    }

    @Nested
    @DisplayName("updateのテスト")
    inner class Update {

        @Test
        @DisplayName("PUTリクエストのレスポンスが返る事")
        fun update() {
            given(mockCoinBoxService.update(CoinBox(120, 2, 0, 1, 0, 0, 122, 120, 121, 120, 120)))
                .willReturn(
                    true
                )

            val requestBody = CoinBox(120, 2, 0, 1, 0, 0, 122, 120, 121, 120, 120)
            val requestBodyJson = mapper.writeValueAsString(requestBody)

            mockMvc.perform(
                put("/api/coin-box")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(requestBodyJson)
            )
                .andExpect(status().isOk)
                .andExpect(content().string("true"))
        }
    }
}