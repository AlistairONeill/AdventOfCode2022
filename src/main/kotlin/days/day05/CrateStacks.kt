package days.day05

import java.util.*

data class CrateStacks(
    val stacks: List<Stack<Char>>
) {
    companion object {
        fun parse(input: String): CrateStacks = parse(input.lines())

        fun parse(input: List<String>): CrateStacks {
            val lines = input.reversed()
            val indices = lines.first().mapIndexedNotNull { index, c -> if (c == ' ') null else index }

            val stacks = List(indices.size) { Stack<Char>() }
            lines
                .drop(1)
                .forEach { line ->
                    indices.forEachIndexed { stackIndex, inputIndex ->
                        if (inputIndex < line.length) {
                            val crate = line[inputIndex]
                            if (crate != ' ') {
                                stacks[stackIndex].push(crate)
                            }
                        }
                    }
                }

            return CrateStacks(stacks)
        }
    }

    fun useCrateMover9000(step: Step) {
        repeat(step.quantity) {
            stacks[step.from - 1]
                .pop()
                .let(stacks[step.to - 1]::push)
        }
    }

    fun useCrateMover9001(step: Step) {
        List(step.quantity) { stacks[step.from - 1].pop() }
            .reversed()
            .forEach(stacks[step.to - 1]::push)
    }

    fun readTop() : String =
        stacks.joinToString("") { it.peek().toString() }
}