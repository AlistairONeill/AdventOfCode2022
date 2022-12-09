package days.day08


object Day8 {
    val input = javaClass.getResource("input.txt").readText()

    fun part1(input: String) : Int =
        Forest.parse(input)
            .trees
            .flatten()
            .count(Forest.Tree::isVisible)

    fun part2(input: String) : Int =
        Forest.parse(input)
            .trees
            .flatten()
            .maxOf(Forest.Tree::scenicScore)
}