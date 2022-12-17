package days.day15

import kotlin.math.abs

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

    private val range = location.manhatten(closestBeacon)
    val minX = location.x - range
    val maxX = location.x + range

    fun getXRange(y: Long) : Pair<Long, Long>? =
        getXWidth(y)
            ?.let { width ->
                location.x - width to location.x + width
            }

    private fun getXWidth(y: Long) : Long? {
        val yDiff = abs(y - location.y)
        if (yDiff > range) return null
        return abs(range - yDiff)
    }
}