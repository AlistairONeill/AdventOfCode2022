package days.day08

import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo
import strikt.assertions.isFalse
import strikt.assertions.isTrue

class ForestTest {
    private val forest = Forest.parse(Day8Test.testInput)

    @Nested
    inner class CartesianVisibility {
        @Test
        fun `example one`() {
            expectThat(
                forest[1,1]
            ) {
                get { isVisibleNorth }
                    .isTrue()

                get { isVisibleWest }
                    .isTrue()

                get { isVisibleEast }
                    .isFalse()

                get { isVisibleSouth }
                    .isFalse()
            }
        }

        @Test
        fun `example two`() {
            expectThat(
                forest[2,1]
            ) {
                get { isVisibleNorth }
                    .isTrue()

                get { isVisibleWest }
                    .isFalse()

                get { isVisibleEast }
                    .isTrue()

                get { isVisibleSouth }
                    .isFalse()
            }
        }

        @Test
        fun `example three`() {
            expectThat(
                forest[3,1]
            ) {
                get { isVisibleNorth }
                    .isFalse()

                get { isVisibleWest }
                    .isFalse()

                get { isVisibleEast }
                    .isFalse()

                get { isVisibleSouth }
                    .isFalse()
            }
        }

        @Test
        fun `example four`() {
            expectThat(
                forest[1,2]
            ) {
                get { isVisibleNorth }
                    .isFalse()

                get { isVisibleWest }
                    .isFalse()

                get { isVisibleEast }
                    .isTrue()

                get { isVisibleSouth }
                    .isFalse()
            }
        }

        @Test
        fun `example five`() {
            expectThat(
                forest[2,2]
            ) {
                get { isVisibleNorth }
                    .isFalse()

                get { isVisibleWest }
                    .isFalse()

                get { isVisibleEast }
                    .isFalse()

                get { isVisibleSouth }
                    .isFalse()
            }
        }

        @Test
        fun `example six`() {
            expectThat(
                forest[2,3]
            ) {
                get { isVisibleNorth }
                    .isFalse()

                get { isVisibleWest }
                    .isTrue()

                get { isVisibleEast }
                    .isFalse()

                get { isVisibleSouth }
                    .isTrue()
            }
        }

        @Test
        fun `example seven`() {
            expectThat(
                forest[3,3]
            ) {
                get { isVisibleNorth }
                    .isFalse()

                get { isVisibleEast }
                    .isFalse()

                get { isVisibleSouth }
                    .isFalse()

                get { isVisibleWest }
                    .isFalse()
            }
        }
    }

    @Nested
    inner class ScenicScore {
        @Test
        fun `example one`() {
            expectThat(
                forest[2,1]
            )
                .get { scenicScore }
                .isEqualTo(4)
        }

        @Test
        fun `example two`() {
            expectThat(
                forest[2, 3]
            )
                .get { scenicScore }
                .isEqualTo(8)
        }

        @Test
        fun `edge case`() {
            expectThat(
                forest[4, 1]
            )
                .get { scenicScore }
                .isEqualTo(0)
        }
    }
}