package days.day09

import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

class Day9Test {
    val testInput = javaClass.getResource("testInput.txt").readText()

    @Test
    fun `can solve part 1 with test input`() {
        expectThat(
            Day9.part1(testInput)
        )
            .isEqualTo(13)
    }

    @Test
    fun `can solve part 2 with test input`() {
        expectThat(
            Day9.part2(testInput)
        )
            .isEqualTo(1)
    }

    @Test
    fun `can solve part 2 with extra test input`() {
        expectThat(
            Day9.part2(javaClass.getResource("testInput2.txt").readText())
        )
            .isEqualTo(36)
    }
}