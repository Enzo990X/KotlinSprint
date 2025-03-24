package org.example.lesson_12

fun main() {
    val mondayWeather = DailyWeather(11F, 1.5F, true)
    val tuesdayWeather = DailyWeather(9F, -2.5F, false)

    mondayWeather.showDailyWeather()
    tuesdayWeather.showDailyWeather()
}

class DailyWeather(
    var dayTemp: Float = 10F,
    var nightTemp: Float = 0F,
    var fallout: Boolean = false,
) {

    fun showDailyWeather() {

        println("Дневная температура: $dayTemp, ночная температура: $nightTemp.")

        if (fallout) println("Ожидаются осадки.")
        else println("Осадки не ожидаются.")
    }
}