package org.example.lesson_1

fun main() {
    val secondsInSpace = 6480
    val hours: Int = secondsInSpace / SECONDS_IN_HOUR
    val minutes: Int = secondsInSpace / SECONDS_IN_MINUTE - hours * MINUTES_IN_HOUR
    val seconds: Int = secondsInSpace - hours * SECONDS_IN_HOUR - minutes * SECONDS_IN_MINUTE

    println("${String.format("%02d", hours)}:$minutes:$seconds")
}

const val SECONDS_IN_HOUR = 3600
const val SECONDS_IN_MINUTE = 60
const val MINUTES_IN_HOUR = 60