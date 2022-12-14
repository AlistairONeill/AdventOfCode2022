package days.day11

import underware.split

class KeepAway(
    private val monkeys: List<Monkey>,
    private val worryStrategy: WorryStrategy
) {
    private val lcm : Long = monkeys.map(Monkey::divisor).fold(1L, Long::times)

    class Monkey(
        val operation: (Long) -> Long,
        val divisor : Long,
        val a: Int,
        val b: Int,
        val items: MutableList<Long>
    ) {
        var inspections: Int = 0

        companion object {
            fun parse(input: List<String>): Monkey {
                val (symbol, raw) = input[2].removePrefix("  Operation: new = old ").split(" ")
                val operand = raw.toLongOrNull()

                return Monkey(
                    operation = when (symbol) {
                        "+" -> { old -> old + (operand ?: old) }
                        "*" -> { old -> old * (operand ?: old) }
                        else -> throw IllegalArgumentException("Invalid operation [$symbol]")
                    },
                    divisor = input[3].removePrefix("  Test: divisible by ").toLong(),
                    a = input[4].removePrefix("    If true: throw to monkey ").toInt(),
                    b = input[5].removePrefix("    If false: throw to monkey ").toInt(),
                    items = input[1]
                        .removePrefix("  Starting items: ")
                        .split(", ")
                        .map(String::toLong)
                        .toMutableList()
                )
            }
        }
    }

    enum class WorryStrategy {
        DivideByThree, LCM
    }

    companion object {
        fun parse(input: String, strategy: WorryStrategy): KeepAway =
            input.lines()
                .split(String::isBlank)
                .map(Monkey::parse)
                .let { KeepAway(it, strategy)}
    }

    fun performRound() {
        monkeys.forEach(::performTurn)
    }

    val monkeyBusiness
        get() = monkeys
            .map(Monkey::inspections)
            .sortedDescending()
            .take(2)
            .fold(1L, Long::times)

    private fun performTurn(monkey: Monkey) {
        while (monkey.items.isNotEmpty()) {
            monkey.inspect(monkey.items.removeFirst())
        }
    }

    private fun Monkey.inspect(item: Long) {
        inspections += 1

        val worry = operation(item).let {
            when (worryStrategy) {
                WorryStrategy.DivideByThree -> it / 3
                WorryStrategy.LCM -> it % lcm
            }
        }

        monkeys[if (worry % divisor == 0L) a else b].items.add(worry)
    }
}