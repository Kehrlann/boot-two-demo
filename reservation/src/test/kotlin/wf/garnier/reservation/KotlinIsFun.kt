package wf.garnier.reservation

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class KotlinIsFun {

    @Test
    fun `kotlin is fun !`() {
        val myClass = User()

        assertThat(myClass.name).isEqualTo("Daniel")
    }

    @Test
    fun `kotlin has constructors`() {
        val user = User("Luis")
        assertThat(user.name).isEqualTo("Luis")
    }

    @Test
    fun `kotlin has cool functions`() {
        val user = User("Luis")
        assertThat(user.hello()).isEqualTo("Hello, Luis !")
    }

    @Test
    fun `data classes`() {
        val one = User("Daniel")
        val two = User("Daniel")

        assertThat(one).isEqualTo(two)

        val three = two.copy(name = "Luis")

        assertThat(three).isNotEqualTo(two)
        println(three)
    }

    @Test
    fun `collections`() {
        val names = listOf("Daniel", "Luis", "Derek")
        val people = names
                .filter { it.startsWith("D") }
                .map { it.toLowerCase() }

        assertThat(people).containsExactlyInAnyOrder("derek", "daniel")
    }
}

data class User(val name: String = "Daniel") {
    fun hello() = "Hello, $name !"
}