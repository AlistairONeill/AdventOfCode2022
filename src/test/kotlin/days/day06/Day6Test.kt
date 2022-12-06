package days.day06

import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

class Day6Test {
    private val testInput = javaClass.getResource("testInput.txt").readText()

    @Test
    fun `can solve part 1 with test input`() {
        expectThat(
            Day6.part1(testInput)
        )
            .isEqualTo(7)
    }

    @Test
    fun `can solve using extra test inputs`() {
        listOf(
            "bvwbjplbgvbhsrlpgdmjqwftvncz" to 5,
            "nppdvjthqldpwncqszvftbrmjlhg" to 6,
            "nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg" to 10,
            "zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw" to 11
        )
            .forEach { (data, expected) ->
                expectThat(
                    Day6.part1(data)
                )
                    .isEqualTo(expected)
            }

    }

    @Test
    fun `can solve part 2 with test input`() {
        expectThat(
            Day6.part2(testInput)
        )
            .isEqualTo(19)
    }

    @Test
    fun `can solve part 2 using extra test inputs`() {
        listOf(
            "bvwbjplbgvbhsrlpgdmjqwftvncz" to 23,
            "nppdvjthqldpwncqszvftbrmjlhg" to 23,
            "nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg" to 29,
            "zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw" to 26
        )
            .forEach { (data, expected) ->
                expectThat(
                    Day6.part2(data)
                )
                    .isEqualTo(expected)
            }

    }
}