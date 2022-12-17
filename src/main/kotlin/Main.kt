import days.day15.Day15

fun main() {
    Day15.part1(
        Day15.input,
        2000000
    )
        .let(::println)

    Day15.part2(
        Day15.input,
        0,
        4000000
    )
        .let(::println)
}