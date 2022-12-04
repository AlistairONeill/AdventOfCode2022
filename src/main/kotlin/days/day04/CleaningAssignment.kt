package days.day04

import kotlin.math.max
import kotlin.math.min

data class CleaningAssignment(
    val first: Int,
    val last: Int
) {
    companion object {
        fun parse(input: String) : CleaningAssignment {
            val split = input.split("-")
            return CleaningAssignment(
                split[0].toInt(),
                split[1].toInt()
            )
        }
    }

    operator fun contains(other: CleaningAssignment) : Boolean =
        first <= other.first && last >= other.last
}

data class CleaningAssignmentPair(
    val first: CleaningAssignment,
    val second: CleaningAssignment
) {
    companion object {
        fun parse(input: String) : CleaningAssignmentPair {
            val split = input.split(",")
            return CleaningAssignmentPair(
                CleaningAssignment.parse(split[0]),
                CleaningAssignment.parse(split[1])
            )
        }
    }

    val isCompleteOverlap: Boolean get() =
        first in second || second in first

    val hasOverlap : Boolean get() =
        min(first.last, second.last) >= max(first.first, second.first)
}

fun parseCleaningAssignmentPairs(input: String) : List<CleaningAssignmentPair> =
    input.lines()
        .map(CleaningAssignmentPair::parse)