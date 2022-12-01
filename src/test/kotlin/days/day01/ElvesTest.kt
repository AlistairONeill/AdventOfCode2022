package days.day01

import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.containsExactlyInAnyOrder
import strikt.assertions.isEqualTo
import strikt.assertions.single

class ElvesTest {
    private val jim = Elf(
        listOf(
            Calorie(1),
            Calorie(2)
        )
    )

    private val dave = Elf(
        listOf(
            Calorie(3),
            Calorie(4)
        )
    )

    private val mick = Elf(
        listOf(
            Calorie(1),
            Calorie(5)
        )
    )
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
                Elf(
                    listOf(
                        Calorie(123),
                        Calorie(456)
                    )
                )
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
                    listOf(
                        Elf(
                            listOf(
                                Calorie(123),
                                Calorie(456)
                            )
                        ),
                        Elf(
                            listOf(
                                Calorie(789),
                                Calorie(1011)
                            )
                        )
                    )
                )
            )
    }

    @Test
    fun `can find the Elf with the most calories`() {
        expectThat(
            Elves(
                listOf(
                    jim, dave, mick
                )
            )
        )
            .get { fattest }
            .isEqualTo(dave)
    }

    @Test
    fun `can find the Elves with the most calories`() {
        expectThat(
            Elves(
                listOf(
                    jim, dave, mick
                )
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
                    Elf(
                        listOf(
                            Calorie(1),
                            Calorie(2)
                        )
                    ),
                    Elf(
                        listOf(
                            Calorie(1),
                            Calorie(2)
                        )
                    )
                )
            )
        )
            .get { getFattest(2) }
            .containsExactlyInAnyOrder(
                Elf(
                    listOf(
                        Calorie(1),
                        Calorie(2)
                    )
                ),
                Elf(
                    listOf(
                        Calorie(1),
                        Calorie(2)
                    )
                )
            )
    }
}