package days.day13

sealed interface Item : Comparable<Item> {
    data class ListItem(private val parts: List<Item>) : Item {
        override fun compareTo(other: Item): Int =
            when (other) {
                is ListItem -> compareTo(other)
                is NumberItem -> compareTo(ListItem(listOf(other)))
            }

        private fun compareTo(other: ListItem) : Int {
            var i = 0
            while (true) {
                if (i == parts.size && i == other.parts.size) return 0
                if (i == parts.size) return -1
                if (i == other.parts.size) return 1
                val compare = parts[i].compareTo(other.parts[i])
                if (compare != 0) return compare
                i += 1
            }
        }
    }

    data class NumberItem(val value: Int) : Item {
        override fun compareTo(other: Item): Int =
            when (other) {
                is ListItem -> ListItem(listOf(this)).compareTo(other)
                is NumberItem -> value.compareTo(other.value)
            }
    }

    companion object {
        val dividerTwo: Item = parse("[[2]]")
        val dividerSix: Item = parse("[[6]]")

        fun parse(input: String) : Item = parse(input.iterator().also(CharIterator::next))

        private fun parse(input: Iterator<Char>) : Item {
            val parts = mutableListOf<Item>()
            while (true) {
                val next = input.next()
                if (next == '[') parts.add(parse(input))
                if (next == ']') break
                if (next.isDigit()) {
                    val (part, close) = parse(next.toString().toInt(), input)
                    parts.add(part)
                    if (close) break
                }
            }
            return ListItem(parts)
        }

        private fun parse(int: Int, input: Iterator<Char>) : Pair<Item, Boolean> {
            return when (val next = input.next()) {
                ',' -> NumberItem(int) to false
                ']' -> NumberItem(int) to true
                else -> parse(int * 10 + next.toString().toInt(), input)
            }
        }
    }
}