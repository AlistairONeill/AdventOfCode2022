package days.day09


object Day9 {
    val input = javaClass.getResource("input.txt").readText()

    fun part1(input: String) : Int {
        val model = RopeModel(2)

        input
            .lines()
            .map(Command::parse)
            .forEach(model::apply)

        return model.visited.size
    }

    fun part2(input: String) : Int {
        val model = RopeModel(10)

        input
            .lines()
            .map(Command::parse)
            .forEach(model::apply)

        return model.visited.size
    }
}