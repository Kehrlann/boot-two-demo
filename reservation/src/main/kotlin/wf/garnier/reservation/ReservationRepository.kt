package wf.garnier.reservation

import org.springframework.data.repository.PagingAndSortingRepository
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

interface ReservationRepository: PagingAndSortingRepository<Reservation, Long>

@Entity
data class Reservation(
        @Id @GeneratedValue val id: Long = 0L,
        val name: String = ""
)