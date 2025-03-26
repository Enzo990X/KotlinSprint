package org.example.lesson_12

import kotlin.random.Random

fun main() {

    val weatherList = mutableListOf<DailyWeather5>()

    val dayTempRange = DAY_TEMP_MIN..DAY_TEMP_MAX
    val nightTempRange = NIGHT_TEMP_MIN..NIGHT_TEMP_MAX

    for (i in 1..DAYS) {
        val dayTemp = (dayTempRange.random() - KELVIN).toInt()
        val nightTemp = (nightTempRange.random() - KELVIN).toInt()
        val fallout = Random.nextBoolean()
        val dailyWeather = DailyWeather5(dayTemp, nightTemp, fallout)
        weatherList.add(dailyWeather)
    }

    val dayTempList = weatherList.map { it.dayTemp }
    println("Средняя температура днем: ${(dayTempList.average()).toInt()}")
    val nightTempList = weatherList.map { it.nightTemp }
    println("Средняя температура ночью: ${(nightTempList.average()).toInt()}")
    val falloutList = weatherList.count() { it.fallout }
    println("Было $falloutList дней с осадками.")
}

class DailyWeather5(var dayTemp: Int, var nightTemp: Int, var fallout: Boolean)

private const val KELVIN = 273.1F
private const val DAY_TEMP_MIN = 280
private const val DAY_TEMP_MAX = 295
private const val NIGHT_TEMP_MIN = 265
private const val NIGHT_TEMP_MAX = 274
private const val DAYS = 30