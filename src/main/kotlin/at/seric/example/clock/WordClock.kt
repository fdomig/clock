package at.seric.example.clock

import java.time.LocalTime

class WordClock {

    private val hours =
        arrayListOf(
            "twelve",
            "one",
            "two",
            "three",
            "four",
            "five",
            "six",
            "seven",
            "eight",
            "nine",
            "ten",
            "eleven"
        )

    fun get(time: LocalTime = LocalTime.now()): String {

        val hourOffset = when (time.minute * 60 + time.second) {
            in 1950..3499 -> 1
            else -> 0
        }

        val hour = hours[(hourOffset + time.hour) % 12]

        val timeString = when (time.minute * 60 + time.second) {
            in 150..449 -> "five minutes past $hour"
            in 450..749 -> "ten minutes past $hour"
            in 750..1049 -> "quarter past $hour"
            in 1050..1349 -> "twenty minutes past $hour"
            in 1350..1649 -> "twenty five minutes past $hour"
            in 1650..1949 -> "half past $hour"
            in 1950..2249 -> "twenty five minutes to $hour"
            in 2250..2549 -> "twenty minutes to $hour"
            in 2550..2849 -> "quarter to $hour"
            in 2850..3149 -> "ten minutes to $hour"
            in 3150..3449 -> "five minutes to $hour"
            else -> "$hour o'clock"
        }

        return "It is $timeString"
    }
}

fun main(args: Array<String>) {
    println(WordClock().get())
}
