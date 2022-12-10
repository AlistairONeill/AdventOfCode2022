package days.day10


object Day10 {
    val input = javaClass.getResource("input.txt").readText()

    fun part1(input: String) : Int {
        val crt = CRT()
        input
            .lineSequence()
            .map(Command::parse)
            .forEach(crt::apply)

        return listOf(20, 60, 100, 140, 180, 220)
            .sumOf {
                crt.history[it-1] * it
            }
    }

    fun part2(input: String) : List<String> {
        val crt = CRT()
        input
            .lineSequence()
            .map(Command::parse)
            .forEach(crt::apply)

        return (0 until 240)
            .map {
                val x = it % 40
                val sprite = crt.history[it]
                if (x in sprite-1 .. sprite + 1) {
                    "#"
                } else {
                    "."
                }
            }
            .chunked(40)
            .map { line -> line.joinToString("") { it } }
    }
}