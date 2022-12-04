package days.day04

import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

class Day4Test {
    private val testInput = javaClass.getResource("testInput.txt").readText()

    @Test
    fun `can parse test puzzle input`() {
        expectThat(
            parseCleaningAssignmentPairs(testInput)
        )
            .isEqualTo(
                listOf(
                    CleaningAssignmentPair(
                        CleaningAssignment(2,4),
                        CleaningAssignment(6,8)
                    ),
                    CleaningAssignmentPair(
                        CleaningAssignment(2,3),
                        CleaningAssignment(4,5)
                    ),
                    CleaningAssignmentPair(
                        CleaningAssignment(5,7),
                        CleaningAssignment(7,9)
                    ),
                    CleaningAssignmentPair(
                        CleaningAssignment(2,8),
                        CleaningAssignment(3,7)
                    ),
                    CleaningAssignmentPair(
                        CleaningAssignment(6,6),
                        CleaningAssignment(4,6)
                    ),
                    CleaningAssignmentPair(
                        CleaningAssignment(2,6),
                        CleaningAssignment(4,8)
                    )
                )
            )
    }

    @Test
    fun `can solve part 1 with test input`() {
        expectThat(
            Day4.part1(testInput)
        )
            .isEqualTo(2)
    }

    @Test
    fun `can solve part 2 with test input`() {
        expectThat(
            Day4.part2(testInput)
        )
            .isEqualTo(4)
    }
}