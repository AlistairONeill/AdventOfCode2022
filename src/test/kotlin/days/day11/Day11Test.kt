package days.day11

import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

class Day11Test {
    val testInput = javaClass.getResource("testInput.txt").readText()

    @Test
    fun `can solve part 1 with test input`() {
        expectThat(
            Day11.part1(testInput)
        )
            .isEqualTo(10605)
    }

    @Test
    fun `can solve part 2 with test input`() {
        expectThat(
            Day11.part2(testInput)
        )
            .isEqualTo(2713310158)
    }
}