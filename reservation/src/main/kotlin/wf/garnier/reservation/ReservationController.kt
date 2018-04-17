package wf.garnier.reservation

import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux

@RestController
class ReservationController(val repo: ReservationRepository,
                            val priceClient: PriceServiceClient) {

    @GetMapping("/hello")
    fun sayHi(@RequestParam("name", defaultValue = "world") name: String?) = "Hello, $name !"

    @GetMapping("/reservation")
    fun listReservations() = repo.findAll()

    @PostMapping("/reservation")
    fun addReservation(@RequestBody reservation: Reservation) = repo.save(reservation)

    @GetMapping("/total")
    fun computeTotal() = Flux.fromIterable(repo.findAll())
            .flatMap {
                priceClient.getPrice(it.name)
            }
            .toIterable()
            .sum()
}
