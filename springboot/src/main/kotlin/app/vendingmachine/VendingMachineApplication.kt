package app.vendingmachine

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class VendingMachineApplication

fun main(args: Array<String>) {
    runApplication<VendingMachineApplication>(*args)
}
