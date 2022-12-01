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
                    listOf(
                        Elf(
                            listOf(
                                Calorie(1000),
                                Calorie(2000),
                                Calorie(3000),
                            )
                        ),
                        Elf(
                            listOf(
                                Calorie(4000)
                            )
                        ),
                        Elf(
                            listOf(
                                Calorie(5000),
                                Calorie(6000)
                            )
                        ),
                        Elf(
                            listOf(
                                Calorie(7000),
                                Calorie(8000),
                                Calorie(9000),
                            )
                        ),
                        Elf(
                            listOf(
                                Calorie(10000)
                            )
                        )
                    )
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