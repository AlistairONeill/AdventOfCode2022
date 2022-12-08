package days.day07

sealed interface LogOutput {
    sealed interface Command : LogOutput {
        sealed interface ChangeDirectory : Command {
            object Root : ChangeDirectory
            object Up : ChangeDirectory
            data class Child(val name: String) : ChangeDirectory

            companion object {
                fun parse(token: String) : ChangeDirectory =
                    when (token) {
                        "/" -> Root
                        ".." -> Up
                        else -> Child(token)
                    }
            }
        }

        object Ls : Command

        companion object {
            fun parse(tokens: List<String>) : Command =
                when (tokens.first()) {
                    "cd" -> ChangeDirectory.parse(tokens[1])
                    "ls" -> Ls
                    else -> throw IllegalArgumentException("${tokens.first()} is not valid")
                }
        }
    }

    sealed interface Result : LogOutput {
        data class Directory(val name: String) : Result
        data class File(val name: String, val size: Long) : Result

        companion object {
            fun parse(tokens: List<String>) : Result =
                when (tokens.first()) {
                    "dir" -> Directory(tokens[1])
                    else -> File(tokens[1], tokens[0].toLong())
                }
        }
    }

    companion object {
        fun parse(line: String) : LogOutput {
            val split = line.split(" ")
            return if (split.first() == "$") {
                Command.parse(split.drop(1))
            } else {
                Result.parse(split)
            }
        }
    }
}