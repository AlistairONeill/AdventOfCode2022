package days.day05

data class Step(
    val quantity: Int,
    val from: Int,
    val to: Int
) {
    companion object {
        private val regex = "move (\\d+) from (\\d+) to (\\d+)".toRegex()

        fun parse(input: String) : Step =
            regex.matchEntire(input)!!
                .groupValues
                .drop(1)
                .let { (quantity, from, to) ->
                    Step(
                        quantity.toInt(),
                        from.toInt(),
                        to.toInt()
                    )
                }
    }
}

object Steps {
    fun parse(input: String) : List<Step> = parse(input.lines())

    fun parse(input: List<String>) : List<Step> = input.map(Step::parse)
}