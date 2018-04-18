package wf.garnier.reservation

import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import reactor.core.publisher.Mono

@Component
class LengthServiceClient(val client: WebClient) {
    val url = "http://bcn-length.cfapps.io"

    fun getLength(name: String): Mono<Int> =
            client.get()
                    .uri("$url/length?name=$name")
                    .retrieve()
                    .bodyToMono(Int::class.java)
}
