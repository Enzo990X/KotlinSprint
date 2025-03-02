package org.example.lesson_2

fun main() {

    val departureHour = 9
    val departureMinute = 39
    val travelTime = 457

    val arrivalMinute = (departureMinute + travelTime % MINUTES_IN_HOUR) % MINUTES_IN_HOUR
    val arrivalHour = (departureHour * MINUTES_IN_HOUR + departureMinute + travelTime) / MINUTES_IN_HOUR

    println("Время прибытия: $arrivalHour:$arrivalMinute")
}

const val MINUTES_IN_HOUR = 60