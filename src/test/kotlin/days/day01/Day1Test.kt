package days.day01

import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

class Day1Test {

    private val testInput = javaClass.getResource("testInput.txt").readText()

    @Test
    fun `can parse test puzzle input`() {
        expectThat(
            Elves.parse(testInput)
        )
            .isEqualTo(
                Elves(
                    Elf(1000, 2000, 3000),
                    Elf(4000),
                    Elf(5000, 6000),
                    Elf(7000, 8000, 9000),
                    Elf(10000)
                )
            )
    }

    @Test
    fun `can solve part 1 with test input`() {
        expectThat(
            Day1.part1(
                testInput
            )
        )
            .isEqualTo(24000)
    }

    @Test
    fun `can solve part 2 with test input`() {
        expectThat(
            Day1.part2(
                testInput
            )
        )
            .isEqualTo(45000)
    }
}