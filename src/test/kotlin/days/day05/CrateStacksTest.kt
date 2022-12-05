package days.day05

import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo
import java.util.*

class CrateStacksTest {
    @Test
    fun `can parse stacks`() {
        expectThat(
            CrateStacks.parse(
                "    [D] \n" +
                        "[Z] [M] \n" +
                        " 1   2 "
            )
        )
            .isEqualTo(
                CrateStacks(
                    listOf(
                        Stack<Char>().apply {
                            push('Z')
                        },
                        Stack<Char>().apply {
                            push('M')
                            push('D')
                        }
                    )
                )
            )
    }

    @Test
    fun `final stack being shorter doesn't break`() {
        expectThat(
            CrateStacks.parse(
                "[D] \n" +
                        "[Z] [M] \n" +
                        " 1   2 "
            )
        )
            .isEqualTo(
                CrateStacks(
                    listOf(
                        Stack<Char>().apply {
                            push('Z')
                            push('D')
                        },
                        Stack<Char>().apply {
                            push('M')
                        }
                    )
                )
            )
    }

    @Nested
    inner class CrateMover9000 {
        @Test
        fun `can move a crate from one stack to another`() {
            val crates = CrateStacks.parse(
                "[D] \n" +
                        "[Z] [M] \n" +
                        " 1   2 "
            )

            crates.useCrateMover9000(Step(1, 1, 2))

            expectThat(crates)
                .isEqualTo(
                    CrateStacks.parse(
                        "    [D] \n" +
                                "[Z] [M] \n" +
                                " 1   2 "
                    )
                )
        }

        @Test
        fun `can move multiple crates from one stack to another`() {
            val crates = CrateStacks.parse(
                "[D] \n" +
                        "[Z] [M] \n" +
                        " 1   2 "
            )

            crates.useCrateMover9000(Step(2, 1, 2))

            expectThat(crates)
                .isEqualTo(
                    CrateStacks.parse(
                        "    [Z] \n" +
                                "    [D] \n" +
                                "    [M] \n" +
                                " 1   2 "
                    )
                )
        }
    }

    @Nested
    inner class CrateMover9001 {
        @Test
        fun `can move a crate from one stack to another`() {
            val crates = CrateStacks.parse(
                "[D] \n" +
                        "[Z] [M] \n" +
                        " 1   2 "
            )

            crates.useCrateMover9001(Step(1, 1, 2))

            expectThat(crates)
                .isEqualTo(
                    CrateStacks.parse(
                        "    [D] \n" +
                                "[Z] [M] \n" +
                                " 1   2 "
                    )
                )
        }

        @Test
        fun `can move multiple crates from one stack to another`() {
            val crates = CrateStacks.parse(
                "[D] \n" +
                        "[Z] [M] \n" +
                        " 1   2 "
            )

            crates.useCrateMover9001(Step(2, 1, 2))

            expectThat(crates)
                .isEqualTo(
                    CrateStacks.parse(
                        "    [D] \n" +
                                "    [Z] \n" +
                                "    [M] \n" +
                                " 1   2 "
                    )
                )
        }
    }


    @Test
    fun `can read top crate of each stack`() {
        val crates = CrateStacks.parse(
            "[D] \n" +
                    "[Z] [M] \n" +
                    " 1   2 "
        )

        expectThat(crates.readTop())
            .isEqualTo("DM")
    }
}