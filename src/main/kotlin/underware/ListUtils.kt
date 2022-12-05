package underware

fun <T: Any> List<T>.split(predicate: (T) -> Boolean) : List<List<T>> {
    val output = ArrayList<List<T>>()
    var current = ArrayList<T>()
    forEach {
        if (predicate(it)) {
            output.add(current)
            current = ArrayList()
        } else {
            current.add(it)
        }
    }
    output.add(current)
    return output
}