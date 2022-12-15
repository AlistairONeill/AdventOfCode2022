package days.day15

import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

class Day15Test {
    val testInput = javaClass.getResource("testInput.txt").readText()

    @Test
    fun `can solve part 1 with test input`() {
        expectThat(
            Day15.part1(testInput, 10)
        )
            .isEqualTo(26)
    }

    @Test
    fun `can solve part 2 with test input`() {
        expectThat(
            Day15.part2(testInput, 0, 20)
        )
            .isEqualTo(56000011)
    }
}