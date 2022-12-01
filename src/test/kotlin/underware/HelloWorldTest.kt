package underware

import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

class HelloWorldTest {
    @Test
    fun `say hello`() {
        expectThat(
            HelloWorld.directly()
        )
            .isEqualTo("HelloWorld!")
    }

    @Test
    fun `can read resource file`() {
        expectThat(
            HelloWorld.fromResource()
        )
            .isEqualTo("HelloWorld!")
    }

    @Test
    fun `can read test resource file`() {
        expectThat(
            javaClass.getResource("Test.txt").readText()
        )
            .isEqualTo("HelloWorld!")
    }
}