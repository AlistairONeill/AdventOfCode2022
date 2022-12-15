package days.day15

import kotlin.math.abs


data class Point(val x: Long, val y: Long) {
    fun manhatten(other: Point) : Long = abs(x - other.x) + abs(y-other.y)

    fun within(other: Point, range: Long) : Boolean {
        val X = abs(x-other.x)
        if (X > range) return false
        val Y = abs(y-other.y)
        if (Y > range) return false
        return X + Y <= range
    }
}