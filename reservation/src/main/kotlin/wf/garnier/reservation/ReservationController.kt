package wf.garnier.reservation

import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux

@RestController
class ReservationController(val repo: ReservationRepository,
                            val lengthClient: LengthServiceClient) {

    @GetMapping("/hello")
    fun sayHi(@RequestParam("name", defaultValue = "world") name: String?) = "Hello, $name !"

    @GetMapping("/reservation")
    fun listReservations() = repo.findAll()

    @PostMapping("/reservation")
    fun addReservation(@RequestBody reservation: Reservation) = repo.save(reservation)

    @GetMapping("/stats")
    fun computeTotal() = Flux.fromIterable(repo.findAll())
            .map {
                UserWithLength(it.name)
            }
            .flatMap {
                val user = it
                lengthClient.getLength(it.name)
                        .map {
                            user.copy(length = it)
                        }
            }
}

data class UserWithLength(val name: String, val length: Int = 0)