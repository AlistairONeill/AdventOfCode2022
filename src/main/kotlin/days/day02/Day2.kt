package days.day02

object Day2 {
    val input = javaClass.getResource("input.txt").readText()

    fun part1(input: String): Long =
        StrategyGuide.parse(input)
            .entries
            .map(StrategyGuide.Entry::toRound)
            .sumOf(Round::score)

    fun part2(input: String): Long =
        StrategyGuide.parse(input)
            .entries
            .map(StrategyGuide.Entry::toRoundPart2)
            .sumOf(Round::score)
}