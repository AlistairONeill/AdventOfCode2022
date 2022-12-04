package days.day04

object Day4 {
    val input = javaClass.getResource("input.txt").readText()

    fun part1(input: String): Long =
        parseCleaningAssignmentPairs(input)
            .count(CleaningAssignmentPair::isCompleteOverlap)
            .toLong()

    fun part2(input: String): Long =
        parseCleaningAssignmentPairs(input)
            .count(CleaningAssignmentPair::hasOverlap)
            .toLong()
}