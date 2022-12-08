package days.day07

import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

class Day7Test {
    private val testInput = javaClass.getResource("testInput.txt").readText()

    @Test
    fun `can solve part 1 with test input`() {
        expectThat(
            Day7.part1(testInput)
        )
            .isEqualTo(95437)
    }

    @Test
    fun `can solve part 2 with test input`() {
        expectThat(
            Day7.part2(testInput)
        )
            .isEqualTo(24933642)
    }
}