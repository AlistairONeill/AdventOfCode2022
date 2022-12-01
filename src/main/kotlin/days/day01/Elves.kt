package days.day01

@JvmInline
value class Elves(
    val value: List<Elf>
) {
    companion object {
        fun parse(input: String) : Elves =
            input.split("\r\n\r\n")
                .map(Elf::parse)
                .let(::Elves)
    }

    val fattest : Elf get() = getFattest(1).single()

    fun getFattest(count: Int) : List<Elf> =
        value
            .sortedByDescending(Elf::totalCalories)
            .take(count)
}