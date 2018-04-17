package wf.garnier.reservation

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.client.WebClient

@SpringBootApplication
class ReservationApplication {
    @Bean
    fun restTemplate(restTemplateBuilder: RestTemplateBuilder) = restTemplateBuilder.build()

    @Bean
    fun webClient() = WebClient.create()
}

fun main(args: Array<String>) {
    runApplication<ReservationApplication>(*args)
}


@Configuration
class MyInit : CommandLineRunner {

    @Autowired
    lateinit var repo: ReservationRepository

    override fun run(vararg args: String?) {
        if (repo.count() == 0L) {
            repo.save(Reservation(name = "Daniel"))
            repo.save(Reservation(name = "Luis"))
        }
        println(repo.findAll())
    }

}