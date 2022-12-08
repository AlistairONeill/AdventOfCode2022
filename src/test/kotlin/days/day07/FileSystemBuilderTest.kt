package days.day07

import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo


class FileSystemBuilderTest {
    @Test
    fun `can build a file system`() {
        val builder = FileSystemBuilder()

        builder.root.contents = FileSystemBuilder.Item.Directory.Contents.Known(
            FileSystemBuilder.Item.File("a", 123)
        )

        expectThat(
            builder.build()
        )
            .isEqualTo(
                FileSystem(
                    FileSystem.Item.Directory("/", FileSystem.Item.File("a", 123))
                )
            )
    }

    @Test
    fun `can build a file system with nested directories`() {
        val builder = FileSystemBuilder()

        builder.root.contents = FileSystemBuilder.Item.Directory.Contents.Known(
            FileSystemBuilder.Item.File("a", 123),
            FileSystemBuilder.Item.Directory(
                "b", FileSystemBuilder.Item.Directory.Contents.Known(
                    FileSystemBuilder.Item.File("c", 456),
                    FileSystemBuilder.Item.File("d", 789)
                )
            )
        )

        expectThat(
            builder.build()
        )
            .isEqualTo(
                FileSystem(
                    FileSystem.Item.Directory(
                        "/",
                        FileSystem.Item.File("a", 123),
                        FileSystem.Item.Directory(
                            "b",
                            FileSystem.Item.File("c", 456),
                            FileSystem.Item.File("d", 789),
                        )
                    )
                )
            )
    }
}