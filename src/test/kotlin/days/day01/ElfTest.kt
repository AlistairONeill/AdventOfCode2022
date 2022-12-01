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
                Elf(123)
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
                Elf(123, 456)
            )
    }

    @Test
    fun `can calculate the total calories`() {
        expectThat(
            Elf(1, 2)
        )
            .get { totalCalories }
            .isEqualTo(
                Calorie(3)
            )
    }
}

operator fun Elf.Companion.invoke(vararg meals: Long) =
    meals
        .map(::Calorie)
        .let(::Elf)