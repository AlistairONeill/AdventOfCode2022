package days.day02

import days.day02.Action.Paper
import days.day02.Action.Rock
import days.day02.StrategyGuide.EnemyAction.A
import days.day02.StrategyGuide.EnemyAction.B
import days.day02.StrategyGuide.Entry
import days.day02.StrategyGuide.OurAction.X
import days.day02.StrategyGuide.OurAction.Y
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.api.expectThrows
import strikt.assertions.isEqualTo

class StrategyGuideTest {
    @Nested
    inner class ParseEntry {
        @Test
        fun `can parse an entry`() {
            expectThat(
                Entry.parse("A X")
            ) {
                get { them }
                    .isEqualTo(A)

                get { us }
                    .isEqualTo(X)
            }
        }

        @Test
        fun `throws if invalid values supplied`() {
            expectThrows<IllegalArgumentException> {
                Entry.parse("X A")
            }
        }

        @Test
        fun `throws if incorrect number of actions supplied`() {
            expectThrows<IllegalArgumentException> {
                Entry.parse("A")
            }

            expectThrows<IllegalArgumentException> {
                Entry.parse("A X B")
            }
        }
    }

    @Test
    fun `can parse multiple entries`() {
        expectThat(
            StrategyGuide.parse("A X\r\nB Y")
        )
            .isEqualTo(
                StrategyGuide(
                    listOf(
                        Entry(A, X),
                        Entry(B, Y)
                    )
                )
            )
    }

    @Test
    fun `can convert entry to a tournament round part 1`() {
        expectThat(
            Entry(A, Y)
        )
            .get { toRound() }
            .isEqualTo(
                Round(Rock, Paper)
            )
    }

    @Test
    fun `can convert entry to a tournament round part 2`() {
        expectThat(
            Entry(A, Y)
        )
            .get { toRoundPart2() }
            .isEqualTo(
                Round(Rock, Rock)
            )
    }
}