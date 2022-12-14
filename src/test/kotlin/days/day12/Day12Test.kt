package days.day12

import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

class Day12Test {
    val testInput = javaClass.getResource("testInput.txt").readText()

    @Test
    fun `can solve part 1 with test input`() {
        expectThat(
            Day12.part1(testInput)
        )
            .isEqualTo(31)
    }

    @Test
    fun `can solve part 2 with test input`() {
        expectThat(
            Day12.part2(testInput)
        )
            .isEqualTo(29)
    }
}