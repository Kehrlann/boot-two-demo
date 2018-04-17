package wf.garnier.reservation

import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

@Component
class PriceServiceClient(val client: WebClient) {
    val url = "http://bcn-price.cfapps.io"

    fun getPrice(name: String): Mono<Int> =
            client.get()
                    .uri("$url/price?name=$name")
                    .retrieve()
                    .bodyToMono(Int::class.java)
}