package days.day02

import days.day02.Action.Paper
import days.day02.Action.Rock
import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

class TournamentTest {
    @Test
    fun `correctly ascertains who won`() {
        expectThat(
            Round(Rock, Paper)
        )
            .get { result }
            .isEqualTo(Result.Win)
    }

    @Test
    fun `can calculate score`() {
        expectThat(
            Round(Rock, Paper)
        )
            .get { score }
            .isEqualTo(8)
    }
}