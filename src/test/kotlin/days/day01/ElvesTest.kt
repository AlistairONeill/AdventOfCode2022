package days.day01

import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.containsExactlyInAnyOrder
import strikt.assertions.isEqualTo
import strikt.assertions.single

class ElvesTest {
    private val jim = Elf(1, 2)
    private val dave = Elf(3, 4)
    private val mick = Elf(1, 5)

    @Test
    fun `can parse for single elf`() {
        expectThat(
            Elves.parse(
                "123\r\n456"
            )
        )
            .get { value }
            .single()
            .isEqualTo(
                Elf(123, 456)
            )
    }

    @Test
    fun `can parse for multiple elves`() {
        expectThat(
            Elves.parse(
                "123\r\n456\r\n\r\n789\r\n1011"
            )
        )
            .isEqualTo(
                Elves(
                    Elf(123, 456),
                    Elf(789, 1011)
                )
            )
    }

    @Test
    fun `can find the Elf with the most calories`() {
        expectThat(
            Elves(
                jim, dave, mick
            )
        )
            .get { fattest }
            .isEqualTo(dave)
    }

    @Test
    fun `can find the Elves with the most calories`() {
        expectThat(
            Elves(
                jim, dave, mick
            )
        )
            .get { getFattest(2) }
            .containsExactlyInAnyOrder(
                dave, mick
            )
    }

    @Test
    fun `identical elves don't cause problems`() {
        expectThat(
            Elves(
                listOf(
                    Elf(1, 2),
                    Elf(1, 2)
                )
            )
        )
            .get { getFattest(2) }
            .containsExactlyInAnyOrder(
                Elf(1, 2),
                Elf(1, 2)
            )
    }
}

operator fun Elves.Companion.invoke(vararg elves: Elf) = Elves(elves.toList())