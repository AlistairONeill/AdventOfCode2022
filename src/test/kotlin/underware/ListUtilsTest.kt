package underware

import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

class ListUtilsTest {
    @Nested
    inner class Split {
        @Test
        fun `can split when predicate matches`() {
            expectThat(
                listOf(
                    1,2,0,3,4,0,5,6
                )
                    .split { it == 0 }
            )
                .isEqualTo(
                    listOf(
                        listOf(1,2),
                        listOf(3,4),
                        listOf(5,6)
                    )
                )
        }
    }
}