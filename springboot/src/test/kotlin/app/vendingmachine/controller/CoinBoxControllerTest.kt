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
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

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
    @DisplayName("findAll")
    inner class FindAll {

        @DisplayName("GETリクエストのレスポンスが返る事")
        @Test
        fun findAll() {
            given(mockCoinBoxService.findAll()).willReturn(CoinBox(100, 120, 120, 120, 120, 120))
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

    @Nested
    @DisplayName("update")
    inner class Update {

        @DisplayName("PUTリクエストのレスポンスが返る事")
        @Test
        fun update() {
            given(mockCoinBoxService.update(CoinBox(120, 122, 120, 121, 120, 120)))
                .willReturn(
                    true
                )

            val requestBody = CoinBox(120, 122, 120, 121, 120, 120)
            val requestBodyJson = mapper.writeValueAsString(requestBody)

            mockMvc.perform(
                put("/api/coin-box")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(requestBodyJson)
            )
                .andExpect(status().isOk)
        }
    }
}