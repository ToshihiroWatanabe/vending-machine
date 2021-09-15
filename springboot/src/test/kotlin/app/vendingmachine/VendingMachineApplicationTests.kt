package app.vendingmachine

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.TestPropertySource

@SpringBootTest
@TestPropertySource(locations = ["classpath:test.properties"])
class VendingMachineApplicationTests {

	@Test
	fun contextLoads() {
	}

//	@Test
//	fun fail(){
//		assertEquals(1,2)
//	}

}
