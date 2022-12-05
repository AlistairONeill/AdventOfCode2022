package days.day05

import underware.split

object Day5 {
    val input = javaClass.getResource("input.txt").readText()

    fun part1(input: String): String =
        parseInput(input)
            .let { (crates, steps) ->
                steps.forEach(crates::useCrateMover9000)
                crates
            }
            .readTop()

    fun part2(input: String): String =
        parseInput(input)
            .let { (crates, steps) ->
                steps.forEach(crates::useCrateMover9001)
                crates
            }
            .readTop()

    fun parseInput(input: String) : Pair<CrateStacks, List<Step>> =
        input.lines()
            .split(String::isBlank)
            .let { (diagram, instructions) ->
                CrateStacks.parse(diagram) to Steps.parse(instructions)
            }

}