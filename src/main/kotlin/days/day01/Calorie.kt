package days.day01

@JvmInline
value class Calorie(val value: Long) : Comparable<Calorie> {
    operator fun plus(other: Calorie) = Calorie(value + other.value)
    override fun compareTo(other: Calorie): Int = value.compareTo(other.value)
}