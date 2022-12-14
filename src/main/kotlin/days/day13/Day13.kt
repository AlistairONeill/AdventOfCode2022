package days.day13

import underware.split


object Day13 {
    val input = javaClass.getResource("input.txt").readText()

    fun part1(input: String) : Int =
        input.lines()
            .split(String::isBlank)
            .mapIndexed { i, (a, b) ->
                if (Item.parse(a) < Item.parse(b)) i + 1 else 0
            }
            .sum()

    fun part2(input: String) : Int {
        val sorted = input.lines()
            .asSequence()
            .filter(String::isNotBlank)
            .map(Item::parse)
            .plus(Item.dividerTwo)
            .plus(Item.dividerSix)
            .sorted()
            .toList()

        return (sorted.indexOf(Item.dividerTwo) + 1) * (sorted.indexOf(Item.dividerSix) + 1)
    }
}