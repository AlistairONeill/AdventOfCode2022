package days.day08

import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

class Day8Test {
    companion object {
        val testInput = Day8Test::class.java.getResource("testInput.txt").readText()
    }

    @Test
    fun `can solve part 1 with test input`() {
        expectThat(
            Day8.part1(testInput)
        )
            .isEqualTo(21)
    }

    @Test
    fun `can solve part 2 with test input`() {
        expectThat(
            Day8.part2(testInput)
        )
            .isEqualTo(8)
    }
}