package days.day02

import days.day02.StrategyGuide.EnemyAction.*
import days.day02.StrategyGuide.Entry
import days.day02.StrategyGuide.OurAction.*
import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

class Day2Test {
    private val testInput = javaClass.getResource("testInput.txt").readText()

    @Test
    fun `can parse test puzzle input`() {
        expectThat(
            StrategyGuide.parse(testInput)
        )
            .isEqualTo(
                StrategyGuide(
                    listOf(
                        Entry(A, Y),
                        Entry(B, X),
                        Entry(C, Z),
                    )
                )
            )
    }

    @Test
    fun `can solve part 1 with test input`() {
        expectThat(
            Day2.part1(testInput)
        )
            .isEqualTo(15)
    }

    @Test
    fun `can solve part 2 with test input`() {
        expectThat(
            Day2.part2(
                testInput
            )
        )
            .isEqualTo(12)
    }
}