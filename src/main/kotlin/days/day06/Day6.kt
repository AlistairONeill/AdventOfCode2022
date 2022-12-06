package days.day06

object Day6 {
    val input = javaClass.getResource("input.txt").readText()

    fun part1(input: String): Int =
        input
            .windowedSequence(4)
            .indexOfFirst(String::isStartOfPacket)
            .plus(4)

    fun part2(input: String): Int =
        input
            .windowedSequence(14)
            .indexOfFirst(String::isStartOfPacket)
            .plus(14)
}