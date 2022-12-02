package days.day02

import days.day02.Action.*
import days.day02.Result.*

data class Round(
    val them : Action,
    val us: Action
) {
    val result: Result get() =
        when (them) {
            Rock -> when (us) {
                Rock -> Draw
                Paper -> Win
                Scissors -> Lose
            }
            Paper -> when (us) {
                Rock -> Lose
                Paper -> Draw
                Scissors -> Win
            }
            Scissors -> when (us) {
                Rock -> Win
                Paper -> Lose
                Scissors -> Draw
            }
        }

    val score : Long get() = result.score + us.score

    private val Result.score : Long get() = when (this) {
        Win -> 6
        Lose -> 0
        Draw -> 3
    }

    private val Action.score : Long get() = when (this) {
        Rock -> 1
        Paper -> 2
        Scissors -> 3
    }
}

enum class Action {
    Rock, Paper, Scissors
}

enum class Result {
    Win, Lose, Draw
}