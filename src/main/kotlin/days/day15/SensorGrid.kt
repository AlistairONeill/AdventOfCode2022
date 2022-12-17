package days.day15

import kotlin.math.max

class SensorGrid(
    private val sensors: List<Sensor>
) {
    companion object {
        fun parse(input: String) =
            input.lines()
                .map(Sensor::parse)
                .let(::SensorGrid)
    }

    fun countOfNoBeacons(y: Long): Int {
        val ranges = sensors
            .mapNotNull { sensor -> sensor.getXRange(y) }

        return (sensors.minOf(Sensor::minX)..sensors.maxOf(Sensor::maxX))
            .count { test ->
                ranges.any { (x, y) ->
                    test in x..y
                }
            } - sensors.map(Sensor::closestBeacon).toSet().count { it.y == y }
    }

    fun findBeacon(min: Long, max: Long): Point {
        (min..max)
            .forEach { y ->
                try {
                    sensors
                        .mapNotNull { sensor -> sensor.getXRange(y) }
                        .sortedBy(Pair<Long, Long>::first)
                        .reduceOrNull { range1, range2 ->
                            when {
                                range1.second >= range2.first -> range1.first to max(range1.second, range2.second)
                                range1.second == range2.first - 2 -> throw XValue(range1.second + 1)
                                else -> throw RuntimeException("Puzzle says this isn't possible")
                            }
                        }
                } catch (e: XValue) {
                    return Point(e.x, y)
                }
            }

        throw RuntimeException("Didn't find solution :(")
    }
}

private class XValue(val x: Long) : Exception()