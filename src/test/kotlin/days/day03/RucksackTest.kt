package days.day03

import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

class RucksackTest {
    @Test
    fun `can parse`() {
        expectThat(
            Rucksack.parse("abcdef")
        ) {
            get { firstCompartment }
                .isEqualTo("abc".toList())

            get { secondCompartment }
                .isEqualTo("def".toList())
        }
    }

    @Test
    fun `can parse multiple rucksacks`() {
        expectThat(
            Rucksacks.parse("abcd\r\nefgh")
        )
            .isEqualTo(
                listOf(
                    Rucksack("ab".toList(), "cd".toList()),
                    Rucksack("ef".toList(), "gh".toList())
                )
            )
    }

    @Test
    fun `can find duplicated item between compartments`() {
        expectThat(
            Rucksack(
                "abc".toList(),
                "adf".toList()
            )
        )
            .get { findError() }
            .isEqualTo('a')
    }

    @Test
    fun `ignores duplicated items in same compartment`() {
        expectThat(
            Rucksack(
                "abb".toList(),
                "add".toList()
            )
        )
            .get { findError() }
            .isEqualTo('a')
    }

    @Test
    fun `duplicate example from puzzle`() {
        expectThat(
            Rucksack.parse("jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL")
        )
            .get { findError() }
            .isEqualTo('L')
    }

    @Test
    fun `character priorities are mapped correctly`() {
        expectThat('a'.priority)
            .isEqualTo(1)

        expectThat('z'.priority)
            .isEqualTo(26)

        expectThat('A'.priority)
            .isEqualTo(27)

        expectThat('Z'.priority)
            .isEqualTo(52)
    }

    @Test
    fun `can find label for groups of rucksacks`() {
        expectThat(
            listOf(
                Rucksack.parse("vJrwpWtwJgWrhcsFMMfFFhFp"),
                Rucksack.parse("jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL"),
                Rucksack.parse("PmmdzqPrVvPwwTWBwg")
            )
        )
            .get { findLabel() }
            .isEqualTo('r')

        expectThat(
            listOf(
                Rucksack.parse("wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn"),
                Rucksack.parse("ttgJtRGJQctTZtZT"),
                Rucksack.parse("CrZsJsPPZsGzwwsLwLmpwMDw")
            )
        )
            .get { findLabel() }
            .isEqualTo('Z')
    }
}