package days.day13

import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

class Day13Test {
    val testInput = javaClass.getResource("testInput.txt").readText()

    @Test
    fun `can solve part 1 with test input`() {
        expectThat(
            Day13.part1(testInput)
        )
            .isEqualTo(13)
    }

    @Test
    fun `can solve part 2 with test input`() {
        expectThat(
            Day13.part2(testInput)
        )
            .isEqualTo(140)
    }
}