package days.day15


object Day15 {
    val input = javaClass.getResource("input.txt").readText()

    fun part1(input: String, y: Long): Int =
        SensorGrid.parse(input)
            .countOfNoBeacons(y)

    fun part2(input: String, min: Long, max: Long): Long =
        SensorGrid.parse(input)
            .findBeacon(min, max)
            .let { (x, y) -> x * 4000000 + y }
}