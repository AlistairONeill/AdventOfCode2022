package days.day10

sealed interface Command {
    object NoOp : Command
    data class Add(val value: Int) : Command

    companion object {
        fun parse(line: String) : Command =
            when (line) {
                "noop" -> NoOp
                else -> line.split(" ").last().toInt().let(::Add)
            }
    }
}