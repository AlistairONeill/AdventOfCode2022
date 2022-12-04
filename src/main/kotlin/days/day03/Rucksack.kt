package days.day03

object Rucksacks {
    fun parse(input: String) : List<Rucksack> =
        input
            .lines()
            .map(Rucksack::parse)
}

data class Rucksack(
    val firstCompartment: List<Char>,
    val secondCompartment: List<Char>
) {
    companion object {
        fun parse(input: String): Rucksack =
            input.length
                .div(2)
                .let { mid ->
                    Rucksack(
                        input.take(mid).toList(),
                        input.drop(mid).toList()
                    )
                }
    }

    fun findError() : Char =
        firstCompartment.toSet()
            .intersect(secondCompartment.toSet())
            .single()
}

val Char.priority : Long get() =
    if (isUpperCase()) {
        lowercase().single() - 'a' + 27L
    } else {
        this - 'a' + 1L
    }

fun List<Rucksack>.findLabel() : Char =
    map { rucksack -> rucksack.firstCompartment + rucksack.secondCompartment }
        .map(List<Char>::toSet)
        .reduce(Set<Char>::intersect)
        .single()