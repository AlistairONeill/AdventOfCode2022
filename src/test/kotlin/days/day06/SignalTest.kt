package days.day06

import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isFalse
import strikt.assertions.isTrue

class SignalTest {
    @Nested
    inner class StartOfPacket {
        @Test
        fun `can identify a start of packet`() {
            expectThat(
                "abcd"
            )
                .get { isStartOfPacket }
                .isTrue()
        }

        @Test
        fun `is not a start of packet if there are repeated characters`() {
            expectThat(
                "abca"
            )
                .get { isStartOfPacket }
                .isFalse()
        }
    }
}