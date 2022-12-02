package days.day02

import days.day02.Action.*
import days.day02.StrategyGuide.EnemyAction.*
import days.day02.StrategyGuide.OurAction.*

data class StrategyGuide(
    val entries : List<Entry>
) {
    companion object {
        fun parse(input: String) : StrategyGuide =
            input
                .lines()
                .map(Entry::parse)
                .let(::StrategyGuide)
    }

    data class Entry(
        val them : EnemyAction,
        val us : OurAction
    ) {
        companion object {
            fun parse(input: String) : Entry {
                val split = input.split(" ")
                if (split.size != 2) throw IllegalArgumentException("Need two parts. Received [$input]")
                return Entry(
                    EnemyAction.valueOf(split[0]),
                    OurAction.valueOf(split[1])
                )
            }
        }

        fun toRound() : Round =
            Round(
                when (them) {
                    A -> Rock
                    B -> Paper
                    C -> Scissors
                },
                when (us) {
                    X ->  Rock
                    Y ->  Paper
                    Z ->  Scissors
                }
            )

        fun toRoundPart2() : Round =
            when (them) {
                A -> Rock
                B -> Paper
                C -> Scissors
            }.let { them ->
                Round(
                    them,
                    when (them) {
                        Rock -> when (us) {
                            X -> Scissors
                            Y -> Rock
                            Z -> Paper
                        }
                        Paper -> when (us) {
                            X -> Rock
                            Y -> Paper
                            Z -> Scissors
                        }
                        Scissors -> when (us) {
                            X -> Paper
                            Y -> Scissors
                            Z -> Rock
                        }
                    }
                )
            }
    }

    enum class EnemyAction {
        A, B, C
    }

    enum class OurAction {
        X, Y, Z
    }
}