package org.example.lesson_1

fun main() {
    val secondsInSpace = 6480
    val hours: Int = secondsInSpace / 3600
    val minutes: Int = secondsInSpace / 60 - hours * 60
    val seconds: Int = secondsInSpace - hours * 3600 - minutes * 60

    println("$hours:$minutes:$seconds")
}