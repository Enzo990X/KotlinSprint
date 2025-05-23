package org.example.lesson_12

fun main() {
    val mondayWeather = DailyWeather3(dayTemp = 280, nightTemp = 274, fallout = true)

    val tuesdayWeather = DailyWeather3(dayTemp = 283, nightTemp = 270, fallout = false)

    mondayWeather.showDailyWeather()
    tuesdayWeather.showDailyWeather()
}

class DailyWeather3 (dayTemp: Int, nightTemp: Int, fallout: Boolean)
{
    var dayTemp = (dayTemp- KELVIN).toInt()
    var nightTemp = (nightTemp - KELVIN).toInt()
    var fallout = fallout

    fun showDailyWeather() {

        println("Дневная температура: $dayTemp, " +
                "ночная температура: $nightTemp.")

        if (fallout) println("Ожидаются осадки.")
        else println("Осадки не ожидаются.")
    }
}

private const val KELVIN = 273.1F