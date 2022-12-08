package days.day07

import java.lang.RuntimeException

class FileSystemBuilder {
    val root = Item.Directory("/", Item.Directory.Contents.Unknown)

    sealed interface Item {
        data class Directory(val name: String, var contents: Contents) : Item {
            sealed interface Contents {
                object Unknown : Contents
                data class Known(val items: MutableList<Item>) : Contents {
                    constructor(vararg items: Item) : this(items.toMutableList())
                }
            }
        }

        data class File(val name: String, val size: Long) : Item
    }

    fun build(): FileSystem =
        FileSystem(
            root.build()
        )

    private fun Item.build(): FileSystem.Item =
        when (this) {
            is Item.Directory -> build()
            is Item.File -> build()
        }

    private fun Item.Directory.build(): FileSystem.Item.Directory =
        contents.run {
            when (this) {
                is Item.Directory.Contents.Known -> FileSystem.Item.Directory(name, items.map { it.build() })
                Item.Directory.Contents.Unknown -> throw RuntimeException("NOT EXPLORED DIRECTORY")
            }
        }


    private fun Item.File.build(): FileSystem.Item.File =
        FileSystem.Item.File(name, size)

    fun assess(logOutput: List<LogOutput>) {
        var stack = mutableListOf(root)
        logOutput.forEach { line ->
            when (line) {
                is LogOutput.Command.ChangeDirectory.Child ->
                    stack.last()
                        .contents
                        .let { it as Item.Directory.Contents.Known }
                        .items
                        .filterIsInstance<Item.Directory>()
                        .single { it.name == line.name }
                        .let(stack::add)

                LogOutput.Command.ChangeDirectory.Root -> stack = mutableListOf(root)
                LogOutput.Command.ChangeDirectory.Up -> stack.removeLast()
                LogOutput.Command.Ls -> stack.last().contents = Item.Directory.Contents.Known()
                is LogOutput.Result.Directory -> stack.last()
                    .contents
                    .let { it as Item.Directory.Contents.Known }
                    .items
                    .add(Item.Directory(line.name, Item.Directory.Contents.Unknown))
                is LogOutput.Result.File -> stack.last()
                    .contents
                    .let { it as Item.Directory.Contents.Known }
                    .items
                    .add(Item.File(line.name, line.size))
            }
        }
    }
}