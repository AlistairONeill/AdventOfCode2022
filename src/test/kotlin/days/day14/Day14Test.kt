package days.day14

import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

class Day14Test {
    val testInput = javaClass.getResource("testInput.txt").readText()

    @Test
    fun `can solve part 1 with test input`() {
        expectThat(
            Day14.part1(testInput)
        )
            .isEqualTo(24)
    }

    @Test
    fun `can solve part 2 with test input`() {
        expectThat(
            Day14.part2(testInput)
        )
            .isEqualTo(93)
    }
}