package days.day10

class CRT {
    private var x = 1
    val history = mutableListOf<Int>()

    fun apply(command: Command) {
        when (command) {
            is Command.Add -> {
                history.add(x)
                history.add(x)
                x += command.value
            }
            Command.NoOp -> history.add(x)
        }
    }
}