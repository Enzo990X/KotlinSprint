package org.example.lesson_2

fun main() {

    val departureHour = 9
    val departureMinute = 39
    val travelTime = 457

    val arrivalMinute = (departureMinute + travelTime % 60) % 60
    val arrivalHour = (departureHour*60 + departureMinute + travelTime)/60

    println("Время прибытия: $arrivalHour:$arrivalMinute")
}