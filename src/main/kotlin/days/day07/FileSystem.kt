package days.day07

data class FileSystem(
    val root: Item.Directory
) {
    sealed interface Item {
        val name: String
        val size: Long
        fun flatten() : List<Item>

        data class Directory(override val name: String, val items: List<Item>) : Item {
            constructor(name: String, vararg items: Item) : this(name, items.toList())
            override val size = items.sumOf(Item::size)

            override fun flatten(): List<Item> =
                items.flatMap(Item::flatten) + this
        }

        data class File(override val name: String, override val size: Long) : Item {
            override fun flatten(): List<Item> = listOf(this)
        }
    }

    fun flatten() = root.flatten()
}