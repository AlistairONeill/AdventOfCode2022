package days.day14


object Day14 {
    val input = javaClass.getResource("input.txt").readText()

    fun part1(input: String) : Int =
        SandSimulation.parse(input, false)
            .apply(SandSimulation::simulate)
            .sandDropped

    fun part2(input: String) : Int = SandSimulation.parse(input, true)
        .apply(SandSimulation::simulate)
        .sandDropped
}