package days.day01

data class Elf(
    val meals: List<Calorie>
) {
    companion object {
        fun parse(input: String) : Elf =
            input.split("\r\n")
                .map(String::trim)
                .map(String::toLong)
                .map(::Calorie)
                .let(::Elf)
    }

    val totalCalories : Calorie get() =
        meals.fold(Calorie(0)) { acc, meal -> acc + meal }
}