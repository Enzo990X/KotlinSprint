package org.example.lesson_12

fun main() {
    val mondayWeather = DailyWeather()
    mondayWeather.dayTemp = 11F
    mondayWeather.nightTemp = 1.5F
    mondayWeather.fallout = true

    val tuesdayWeather = DailyWeather()
    tuesdayWeather.dayTemp = 9F
    tuesdayWeather.nightTemp = -2.5F
    tuesdayWeather.fallout = false

    mondayWeather.showDailyWeather()
    tuesdayWeather.showDailyWeather()
}

class DailyWeather {

    var dayTemp: Float = 10F
    var nightTemp: Float = 0F
    var fallout: Boolean = false

    fun showDailyWeather() {

        println("Дневная температура: $dayTemp, ночная температура: $nightTemp.")

        if (fallout) println("Ожидаются осадки.")
        else println("Осадки не ожидаются.")
    }
}