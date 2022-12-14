package days.day14

class SandSimulation(rocks: Set<Pair<Int, Int>>) {
    private val blocked = rocks.toMutableSet()
    private val maxY = rocks.maxOf(Pair<Int, Int>::second)

    var sandDropped = 0

    companion object {
        fun parse(input: String, infiniteFloor: Boolean) : SandSimulation {
            val rocks = input.lineSequence()
                .flatMap { line ->
                    line
                        .split(" -> " )
                        .asSequence()
                        .map { point ->
                            point
                                .split(",")
                                .let { (x, y) -> x.toInt() to y.toInt() }
                        }
                        .zipWithNext { (x1, y1), (x2, y2) ->
                            when {
                                x1 == x2 -> (minOf(y1, y2) .. maxOf(y1, y2)).map { y -> x1 to y }
                                y1 == y2 -> (minOf(x1, x2) .. maxOf(x1, x2)).map { x -> x to y1 }
                                else -> throw IllegalArgumentException()
                            }
                        }
                        .flatten()
                }
                .toSet()

            val floor = if (infiniteFloor) {
                val floorY = rocks.maxOf(Pair<Int,Int>::second) + 2
                val minX = 500 - floorY - 10
                val maxX = 500 + floorY + 10
                (minX .. maxX).map { x -> x to floorY }
            } else {
                emptyList()
            }

            return SandSimulation(rocks + floor)
        }
    }

    fun simulate() {
        do {
            val sand = Sand()
        } while (sand.fall() && sand.y > 0)
    }

    private inner class Sand {
        var x = 500
        var y = 0

        fun fall() : Boolean {
            while (y <= maxY) {
                when {
                    !blocked.contains(x to y+1) -> y += 1
                    !blocked.contains(x-1 to y+1) -> { x -= 1; y += 1 }
                    !blocked.contains(x+1 to y+1) -> { x += 1; y += 1 }
                    else -> { blocked.add(x to y); sandDropped += 1; return true }
                }
            }
            return false
        }
    }
}