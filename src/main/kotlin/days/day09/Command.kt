package days.day09

data class Command(
    val direction: Direction,
    val count: Int
) {
    companion object {
        fun parse(input: String) : Command =
            input.split(" ")
                .let { (direction, count) ->
                    Command(
                        Direction.parse(direction),
                        count.toInt()
                    )
                }
    }

    enum class Direction {
        Up, Down, Left, Right;

        companion object {
            fun parse(input: String) : Direction =
                when (input) {
                    "R" -> Right
                    "L" -> Left
                    "U" -> Up
                    "D" -> Down
                    else -> throw IllegalArgumentException("Unknown direction [$input]")
                }
        }
    }
}