package days.day12

class SurfaceMap(input: String) {
    private val unsolved: MutableList<Node>
    val nodes : List<Node>
    val target : Node

    init {
        lateinit var start: Node
        lateinit var target: Node
        val nodes = input.lines()
            .map { line ->
                line.map { char ->
                    when (char) {
                        'S' -> Node('a'.code).also { target = it }
                        'E' -> Node('z'.code).also { start = it }
                        else -> Node(char.code)
                    }
                }
            }

        (1 until nodes.size).forEach { y ->
            nodes[y][0].link(nodes[y-1][0])
        }

        (1 until nodes[0].size).forEach { x ->
            nodes[0][x].link(nodes[0][x-1])
        }

        (1 until nodes.size).forEach { y ->
            (1 until nodes[y].size).forEach { x ->
                nodes[y][x].link(nodes[y-1][x])
                nodes[y][x].link(nodes[y][x-1])
            }
        }

        start.minSteps = 0
        this.nodes = nodes.flatten()
        unsolved = this.nodes.toMutableList()
        this.target = target
    }

    class Node(val height: Int) {
        val links = mutableListOf<Node>()

        var minSteps : Int = Int.MAX_VALUE

        fun link(other: Node) {
            if (height < other.height + 2) {
                links.add(other)
            }
            if (other.height < height + 2) {
                other.links.add(this)
            }
        }
    }

    fun dijkstra() {
        while (unsolved.isNotEmpty()) {
            val toConsider = unsolved.minBy(Node::minSteps)
            if (toConsider.minSteps == Integer.MAX_VALUE) break
            unsolved.remove(toConsider)
            toConsider.run {
                links.forEach { other ->
                    other.minSteps = minOf(minSteps + 1, other.minSteps)
                }
            }
        }
    }
}