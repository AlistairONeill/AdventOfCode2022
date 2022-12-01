package days.day01

import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

class ElfTest {
    @Test
    fun `can parse calories in single meal`() {
        expectThat(
            Elf.parse(
                "123"
            )
        )
            .isEqualTo(
                Elf(
                    listOf(
                        Calorie(123)
                    )
                )
            )
    }

    @Test
    fun `can parse when multiple calorie values`() {
        expectThat(
            Elf.parse(
                "123\r\n456"
            )
        )
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
    fun `can calculate the total calories`() {
        expectThat(
            Elf(
                listOf(
                    Calorie(1),
                    Calorie(2)
                )
            )
        )
            .get { totalCalories }
            .isEqualTo(
                Calorie(3)
            )
    }
}