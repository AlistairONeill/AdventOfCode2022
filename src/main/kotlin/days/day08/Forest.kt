package days.day08

class Forest(
    val trees: List<List<Tree>>
) {
    data class Tree(val height: Int) {
        var north: Tree? = null
        var east: Tree? = null
        var south: Tree? = null
        var west: Tree? = null

        val isVisible: Boolean
            get() =
                isVisibleEast || isVisibleNorth || isVisibleSouth || isVisibleWest

        val isVisibleNorth: Boolean by lazy { isVisible(Tree::north) }
        val isVisibleEast: Boolean by lazy { isVisible(Tree::east) }
        val isVisibleSouth: Boolean by lazy { isVisible(Tree::south) }
        val isVisibleWest: Boolean by lazy { isVisible(Tree::west) }

        private fun isVisible(next: Tree.() -> Tree?): Boolean =
            sequence(next).fold(true) { acc, tree -> acc && tree.height < height }

        val scenicScore: Int
            get() =
                scenicScore(Tree::north) * scenicScore(Tree::east) * scenicScore(Tree::south) * scenicScore(Tree::west)

        private fun scenicScore(next: Tree.() -> Tree?): Int {
            var inc = 0
            return sequence(next).takeWhile {
                if (it.height < height) {
                    true
                } else {
                    inc = 1
                    false
                }

            }.count() + inc
        }


        private fun sequence(next: Tree.() -> Tree?): Sequence<Tree> {
            var current: Tree? = this
            return generateSequence {
                current!!.next().also { current = it }
            }
        }
    }

    operator fun get(x: Int, y: Int): Tree = trees[y][x]

    companion object {
        fun parse(input: String): Forest =
            input.lines()
                .map { line -> line.map { it.toString().toInt().let(::Tree) } }
                .let(::Forest)
    }

    init {
        (1 until trees.size).forEach { y ->
            (1 until trees.first().size).forEach { x ->
                trees[y][x].north = trees[y - 1][x]
                trees[y - 1][x].south = trees[y][x]

                trees[y][x].west = trees[y][x - 1]
                trees[y][x - 1].east = trees[y][x]
            }
        }
    }
}

