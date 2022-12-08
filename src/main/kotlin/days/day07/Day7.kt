package days.day07


object Day7 {
    val input = javaClass.getResource("input.txt").readText()

    fun part1(input: String): Long {
        val logOutput = input.lines().map(LogOutput::parse)
        val builder = FileSystemBuilder()
        builder.assess(logOutput)

        return builder.build()
            .root
            .flatten()
            .filterIsInstance<FileSystem.Item.Directory>()
            .map(FileSystem.Item::size)
            .filter { it <= 100_000 }
            .sum()
    }


    fun part2(input: String): Long {
        val logOutput = input.lines().map(LogOutput::parse)
        val builder = FileSystemBuilder()
        builder.assess(logOutput)

        val fileSystem = builder.build()
        val required = 30000000 - 70000000 + fileSystem.root.size

        return fileSystem
            .root
            .flatten()
            .filterIsInstance<FileSystem.Item.Directory>()
            .map(FileSystem.Item::size)
            .filter { it >= required }
            .min()
    }
}