package org.example.lesson_12

fun main() {
    val mondayWeather = DailyWeather1(dayTemp = 11F, nightTemp = 1.5F, fallout = true)

    val tuesdayWeather = DailyWeather1(dayTemp = 9F, nightTemp = -2.5F, fallout = false)

    mondayWeather.showDailyWeather()
    tuesdayWeather.showDailyWeather()
}

class DailyWeather1 (
    var dayTemp: Float,
    var nightTemp: Float,
    var fallout: Boolean,
)
    {
    fun showDailyWeather() {

        println("Дневная температура: $dayTemp, ночная температура: $nightTemp.")

        if (fallout) println("Ожидаются осадки.")
        else println("Осадки не ожидаются.")
    }
}