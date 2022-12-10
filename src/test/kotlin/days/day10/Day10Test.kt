package days.day10


import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

class Day10Test {
    val testInput = javaClass.getResource("testInput.txt").readText()

    @Test
    fun `can solve part 1 with test input`() {
        expectThat(
            Day10.part1(testInput)
        )
            .isEqualTo(13140)
    }

    @Test
    fun `can solve part 2 with test input`() {
        expectThat(
            Day10.part2(testInput)
        )
            .isEqualTo(
                listOf(
                    "##..##..##..##..##..##..##..##..##..##..",
                    "###...###...###...###...###...###...###.",
                    "####....####....####....####....####....",
                    "#####.....#####.....#####.....#####.....",
                    "######......######......######......####",
                    "#######.......#######.......#######.....",
                )
            )
    }
}