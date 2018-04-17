package wf.garnier.slowservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SlowServiceApplication

fun main(args: Array<String>) {
    runApplication<SlowServiceApplication>(*args)
}
