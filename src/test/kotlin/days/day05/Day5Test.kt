package days.day05

import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo
import java.util.*

class Day4Test {
    private val testInput = javaClass.getResource("testInput.txt").readText()

    @Test
    fun `can parse test puzzle input`() {
        expectThat(
            Day5.parseInput(testInput)
        ) {
            get { first }
                .isEqualTo(
                    CrateStacks(
                        listOf(
                            Stack<Char>().apply {
                                push('Z')
                                push('N')
                            },
                            Stack<Char>().apply {
                                push('M')
                                push('C')
                                push('D')
                            },
                            Stack<Char>().apply {
                                push('P')
                            }
                        )
                    )
                )

            get { second }
                .isEqualTo(
                    listOf(
                        Step(1, 2, 1),
                        Step(3, 1, 3),
                        Step(2, 2, 1),
                        Step(1, 1, 2),
                    )
                )
        }

    }

    @Test
    fun `can solve part 1 with test input`() {
        expectThat(
            Day5.part1(testInput)
        )
            .isEqualTo("CMZ")
    }

    @Test
    fun `can solve part 2 with test input`() {
        expectThat(
            Day5.part2(testInput)
        )
            .isEqualTo("MCD")
    }
}