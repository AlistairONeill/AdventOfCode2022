package days.day15

class SensorGrid(
    sensors: Set<Sensor>
) {
    companion object {
        fun parse(input: String) =
            input.lines()
                .map(Sensor::parse)
                .toSet()
                .let(::SensorGrid)
    }

    private val sensors = sensors.sortedByDescending(Sensor::range)

    fun countOfNoBeacons(y: Long) : Int =
        (sensors.minOf(Sensor::minX) .. sensors.maxOf(Sensor::maxX))
            .count { x ->
                val point = Point(x, y)
                val results = sensors.map { sensor -> sensor.isBeacon(point) }

                when {
                    results.any { it == true } -> false
                    results.any { it == false } -> true
                    else -> false
                }
            }

    fun findBeacon(min: Long, max: Long) : Point =
        (min .. max)
            .asSequence()
            .flatMap { x ->
                (min .. max)
                    .asSequence()
                    .map { y -> Point(x, y) }
            }
            .first(::isBeacon)

    private val s = sensors.size
    private var i = 0

    private fun isBeacon(point: Point) : Boolean {
        val j = i
        do {
            if (sensors[i].isBeacon(point) != null) return false
            i += 1
            i %= s
        } while (j != i)

        return true
    }
}