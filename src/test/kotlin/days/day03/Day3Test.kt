package days.day03

import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.all
import strikt.assertions.isEqualTo

class Day3Test {
    private val testInput = javaClass.getResource("testInput.txt").readText()

    @Test
    fun `can parse test puzzle input`() {
        expectThat(
            Rucksacks.parse(testInput)
        ) {
            get { size }
                .isEqualTo(6)

            all {
                get { firstCompartment.size }
                    .isEqualTo(subject.secondCompartment.size)
            }
        }
    }

    @Test
    fun `can solve part 1 with test input`() {
        expectThat(
            Day3.part1(testInput)
        )
            .isEqualTo(157)
    }

    @Test
    fun `can solve part 2 with test input`() {
        expectThat(
            Day3.part2(testInput)
        )
            .isEqualTo(70)
    }
}