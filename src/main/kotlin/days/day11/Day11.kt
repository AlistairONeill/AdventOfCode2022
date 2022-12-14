package days.day11


object Day11 {
    val input = javaClass.getResource("input.txt").readText()

    fun part1(input: String) : Long {
        val keepAway = KeepAway.parse(input, KeepAway.WorryStrategy.DivideByThree)
        repeat(20) {
            keepAway.performRound()
        }
        return keepAway.monkeyBusiness
    }

    fun part2(input: String) : Long {
        val keepAway = KeepAway.parse(input, KeepAway.WorryStrategy.LCM)
        repeat(10000) {
            keepAway.performRound()
        }
        return keepAway.monkeyBusiness
    }
}