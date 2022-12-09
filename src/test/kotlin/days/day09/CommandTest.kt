package days.day09

import days.day09.Command.Direction.Right
import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

class CommandTest {
    @Test
    fun `can parse a command`() {
        expectThat(
            Command.parse("R 4")
        )
            .isEqualTo(
                Command(Right, 4)
            )
    }
}