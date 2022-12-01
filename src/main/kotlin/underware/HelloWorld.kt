package underware

object HelloWorld {
    fun directly() = "HelloWorld!"
    fun fromResource() = javaClass.getResource("HelloWorld.txt").readText()
}
