package days.day07

import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

class LogOutputTest {
    @Nested
    inner class Parse {
        @Test
        fun `change to root`() {
            expectThat(
                LogOutput.parse("\$ cd /")
            )
                .isEqualTo(
                    LogOutput.Command.ChangeDirectory.Root
                )
        }

        @Test
        fun `go up a level`() {
            expectThat(
                LogOutput.parse("\$ cd ..")
            )
                .isEqualTo(
                    LogOutput.Command.ChangeDirectory.Up
                )
        }

        @Test
        fun `go down a level`() {
            expectThat(
                LogOutput.parse("\$ cd e")
            )
                .isEqualTo(
                    LogOutput.Command.ChangeDirectory.Child("e")
                )
        }

        @Test
        fun `list children`() {
            expectThat(
                LogOutput.parse("\$ ls")
            )
                .isEqualTo(
                    LogOutput.Command.Ls
                )
        }

        @Test
        fun `directory output`() {
            expectThat(
                LogOutput.parse("dir e")
            )
                .isEqualTo(
                    LogOutput.Result.Directory("e")
                )
        }

        @Test
        fun `file output`() {
            expectThat(
                LogOutput.parse("62596 h.lst")
            )
                .isEqualTo(
                    LogOutput.Result.File("h.lst", 62596)
                )
        }
    }
}