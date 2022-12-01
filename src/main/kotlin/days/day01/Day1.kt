package days.day01

object Day1 {
    val input = javaClass.getResource("input.txt").readText()

    fun part1(input: String) : Long =
        Elves.parse(input)
            .fattest
            .totalCalories
            .value

    fun part2(input: String) : Long =
        Elves.parse(input)
            .getFattest(3)
            .map(Elf::totalCalories)
            .sumOf(Calorie::value)
}