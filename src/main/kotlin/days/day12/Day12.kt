package days.day12


object Day12 {
    val input = javaClass.getResource("input.txt").readText()

    fun part1(input: String) : Int = SurfaceMap(input)
        .apply(SurfaceMap::dijkstra)
        .target
        .minSteps

    fun part2(input: String) : Int = SurfaceMap(input)
        .apply(SurfaceMap::dijkstra)
        .nodes
        .filter { it.height == 'a'.code }
        .minOf(SurfaceMap.Node::minSteps)
}