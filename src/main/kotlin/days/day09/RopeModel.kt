package days.day09

import days.day09.Command.Direction
import days.day09.Command.Direction.*

class RopeModel(val size: Int) {
    data class Position(val x: Int, val y: Int) {
        fun isTouching(other: Position) : Boolean =
            x in other.x - 1 .. other.x + 1
                    && y in other.y - 1 .. other.y + 1
    }

    private val rope = Array(size) { Position(0, 0) }

    val visited = mutableSetOf<Position>()

    init {
        updateVisited()
    }

    fun apply(command: Command) {
        repeat(command.count) {
            move(command.direction)
        }
    }

    private fun move(direction: Direction) {
        moveHead(direction)
        updateBody()
        updateVisited()
    }

    private fun moveHead(direction: Direction) {
        val head = rope.first()
        rope[0] = when (direction) {
            Up -> Position(head.x, head.y + 1)
            Down -> Position(head.x, head.y - 1)
            Left -> Position(head.x - 1, head.y)
            Right -> Position(head.x + 1, head.y)
        }
    }

    private fun updateBody() {
        (1 until rope.size)
            .forEach {
                rope[it] = getNextPosition(rope[it], rope[it-1])
            }
    }

    private fun getNextPosition(tail: Position, head: Position) : Position =
        when {
            head.x == tail.x ->
                Position(
                    tail.x,
                    when {
                        head.y > tail.y + 1 -> tail.y + 1
                        head.y < tail.y - 1 -> tail.y - 1
                        else -> tail.y
                    }
                )

            head.y == tail.y ->
                Position(
                    when {
                        head.x > tail.x + 1 -> tail.x + 1
                        head.x < tail.x - 1 -> tail.x - 1
                        else -> tail.x
                    },
                    tail.y
                )
            head.isTouching(tail) -> tail
            else ->
                Position(
                    when {
                        head.x > tail.x -> tail.x + 1
                        else -> tail.x - 1
                    },
                    when {
                        head.y > tail.y -> tail.y + 1
                        else -> tail.y - 1
                    }
                )
        }

    private fun updateVisited() {
        visited.add(rope.last())
    }
}