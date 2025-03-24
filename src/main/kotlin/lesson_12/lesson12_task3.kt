package org.example.lesson_12

fun main() {
    val mondayWeather = DailyWeather2(dayTemp = 280, nightTemp = 274, fallout = true)

    val tuesdayWeather = DailyWeather2(dayTemp = 283, nightTemp = 270, fallout = false)

    mondayWeather.showDailyWeather()
    tuesdayWeather.showDailyWeather()
}

class DailyWeather2 (dayTemp: Int, nightTemp: Int, fallout: Boolean)
{
    var dayTemp = dayTemp
    var nightTemp = nightTemp
    var fallout = fallout

    fun showDailyWeather() {

        println("Дневная температура: ${(dayTemp - KELVIN).toInt()}, " +
                "ночная температура: ${(nightTemp - KELVIN).toInt()}.")

        if (fallout) println("Ожидаются осадки.")
        else println("Осадки не ожидаются.")
    }
}

const val KELVIN = 273.1F