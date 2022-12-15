package days.day15

data class Sensor(
    val location: Point,
    val closestBeacon: Point
) {
    companion object {
        private val regex = """Sensor at x=(-?\d+), y=(-?\d+): closest beacon is at x=(-?\d+), y=(-?\d+)""".toRegex()

        fun parse(input: String) =
            regex.matchEntire(input)!!
                .groupValues
                .drop(1)
                .take(4)
                .map(String::toLong)
                .let { (x1, y1, x2, y2) ->
                    Sensor(
                        Point(x1, y1),
                        Point(x2, y2)
                    )
                }
    }

    val range = location.manhatten(closestBeacon)
    val minX = location.x - range
    val maxX = location.x + range

    fun isBeacon(point: Point) : Boolean? =
        when {
            point == closestBeacon -> true
            location.within(point, range) -> false
            else -> null
        }
}