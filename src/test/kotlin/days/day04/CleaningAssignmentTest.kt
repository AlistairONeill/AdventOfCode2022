package days.day04

import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo
import strikt.assertions.isFalse
import strikt.assertions.isTrue

class CleaningAssignmentTest {
    @Nested
    inner class Parsing {
        @Test
        fun `can parse a cleaning assignment`() {
            expectThat(
                CleaningAssignment.parse("2-4")
            )
                .isEqualTo(
                    CleaningAssignment(2, 4)
                )

            expectThat(
                CleaningAssignment.parse("23-413")
            )
                .isEqualTo(
                    CleaningAssignment(23, 413)
                )
        }

        @Test
        fun `can parse a cleaning assignment pair`() {
            expectThat(
                CleaningAssignmentPair.parse("2-4,6-8")
            )
                .isEqualTo(
                    CleaningAssignmentPair(
                        CleaningAssignment(2, 4),
                        CleaningAssignment(6, 8)
                    )
                )

            expectThat(
                CleaningAssignmentPair.parse("23-413,62-891")
            )
                .isEqualTo(
                    CleaningAssignmentPair(
                        CleaningAssignment(23, 413),
                        CleaningAssignment(62, 891)
                    )
                )
        }
    }

    @Nested
    inner class CompleteOverlap {
        @Test
        fun `is a complete overlap when first is contained in second`() {
            expectThat(
                CleaningAssignmentPair(
                    CleaningAssignment(1, 2),
                    CleaningAssignment(0, 4)
                )
            )
                .get { isCompleteOverlap }
                .isTrue()
        }

        @Test
        fun `is a complete overlap when second is contained in first`() {
            expectThat(
                CleaningAssignmentPair(
                    CleaningAssignment(0, 4),
                    CleaningAssignment(1, 2)
                )
            )
                .get { isCompleteOverlap }
                .isTrue()
        }

        @Test
        fun `is a complete overlap when both are equal`() {
            expectThat(
                CleaningAssignmentPair(
                    CleaningAssignment(0, 1),
                    CleaningAssignment(0, 1)
                )
            )
                .get { isCompleteOverlap }
                .isTrue()
        }

        @Test
        fun `is not a complete overlap when disjoint`() {
            expectThat(
                CleaningAssignmentPair(
                    CleaningAssignment(0, 1),
                    CleaningAssignment(2, 3)
                )
            )
                .get { isCompleteOverlap }
                .isFalse()

            expectThat(
                CleaningAssignmentPair(
                    CleaningAssignment(2, 3),
                    CleaningAssignment(0, 1)
                )
            )
                .get { isCompleteOverlap }
                .isFalse()
        }

        @Test
        fun `is not a complete overlap when only partially overlapping`() {
            expectThat(
                CleaningAssignmentPair(
                    CleaningAssignment(0, 2),
                    CleaningAssignment(1, 3)
                )
            )
                .get { isCompleteOverlap }
                .isFalse()

            expectThat(
                CleaningAssignmentPair(
                    CleaningAssignment(1, 3),
                    CleaningAssignment(0, 2)
                )
            )
                .get { isCompleteOverlap }
                .isFalse()
        }
    }

    @Nested
    inner class Overlap {
        @Test
        fun `has overlap when first is contained in second`() {
            expectThat(
                CleaningAssignmentPair(
                    CleaningAssignment(1, 2),
                    CleaningAssignment(0, 4)
                )
            )
                .get { hasOverlap }
                .isTrue()
        }

        @Test
        fun `has overlap when second is contained in first`() {
            expectThat(
                CleaningAssignmentPair(
                    CleaningAssignment(0, 4),
                    CleaningAssignment(1, 2)
                )
            )
                .get { hasOverlap }
                .isTrue()
        }

        @Test
        fun `has overlap when both are equal`() {
            expectThat(
                CleaningAssignmentPair(
                    CleaningAssignment(0, 1),
                    CleaningAssignment(0, 1)
                )
            )
                .get { hasOverlap }
                .isTrue()
        }

        @Test
        fun `does not have overlap when disjoint`() {
            expectThat(
                CleaningAssignmentPair(
                    CleaningAssignment(0, 1),
                    CleaningAssignment(2, 3)
                )
            )
                .get { hasOverlap }
                .isFalse()

            expectThat(
                CleaningAssignmentPair(
                    CleaningAssignment(2, 3),
                    CleaningAssignment(0, 1)
                )
            )
                .get { hasOverlap }
                .isFalse()
        }

        @Test
        fun `has overlap when only partially overlapping`() {
            expectThat(
                CleaningAssignmentPair(
                    CleaningAssignment(0, 2),
                    CleaningAssignment(1, 3)
                )
            )
                .get { hasOverlap }
                .isTrue()

            expectThat(
                CleaningAssignmentPair(
                    CleaningAssignment(1, 3),
                    CleaningAssignment(0, 2)
                )
            )
                .get { hasOverlap }
                .isTrue()
        }
    }
}