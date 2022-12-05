package days.day05

import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

class StepTest {
    @Test
    fun `can parse a step`() {
        expectThat(
            Step.parse("move 1 from 2 to 3")
        )
            .isEqualTo(
                Step(1, 2, 3)
            )
    }

    @Test
    fun `can parse multiple steps`() {
        expectThat(
            Steps.parse(
                "move 1 from 2 to 1\n" +
                        "move 3 from 1 to 3"
            )
        )
            .isEqualTo(
                listOf(
                    Step(1, 2, 1),
                    Step(3, 1, 3)
                )
            )
    }
}