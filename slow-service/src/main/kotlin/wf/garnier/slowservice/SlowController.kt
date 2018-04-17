package wf.garnier.slowservice

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono
import java.time.Duration
import java.util.*

@RestController
class SlowController {

    @GetMapping("/price")
    fun getPrice(@RequestParam("name") name: String) =
            Mono.just(name.length * 3)
                    .delayElement(randomDuration())

    private fun randomDuration() = Duration.ofMillis(1000L + Random().nextInt(1000))
}