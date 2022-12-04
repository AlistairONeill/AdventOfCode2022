package days.day03

object Day3 {
    val input = javaClass.getResource("input.txt").readText()

    fun part1(input: String): Long =
        Rucksacks.parse(input)
            .map(Rucksack::findError)
            .sumOf(Char::priority)

    fun part2(input: String): Long =
        Rucksacks.parse(input)
            .chunked(3)
            .map(List<Rucksack>::findLabel)
            .sumOf(Char::priority)
}