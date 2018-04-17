package wf.garnier.reservation

import org.springframework.web.bind.annotation.*

@RestController
class ReservationController(val repo: ReservationRepository) {

    @GetMapping("/hello")
    fun sayHi(@RequestParam("name", defaultValue = "world") name: String?) = "Hello, $name !"

    @GetMapping("/reservation")
    fun listReservations() = repo.findAll()

    @PostMapping("/reservation")
    fun addReservation(@RequestBody reservation: Reservation) = repo.save(reservation)
}

