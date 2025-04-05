package org.example.lesson_15

fun main() {
    val weatherServer = WeatherServer()
    val message1 = weatherServer.getStats()
    val message2 = weatherServer.getStats()

    weatherServer.sendMessage(message1)
    weatherServer.sendMessage(message2)
}

abstract class WeatherStationStats

class Temperature(val maxTemp: Float, val minTemp: Float) : WeatherStationStats()

class PrecipitationAmount(val amount: Int) : WeatherStationStats()

class WeatherServer {

    fun getStats(): WeatherStationStats {
        while (true) {
            println("Введите данные для отправки на сервер: ")
            val userInput = readln()

            val precipitation = userInput.toIntOrNull()
            if (precipitation != null) {
                println("Получены данные об осадках: $precipitation.\n")
                return PrecipitationAmount(precipitation)
            } else {
                val temperature = userInput.split(',').map { it.trim().toFloatOrNull() }
                if (temperature.all { it != null } && temperature.size == NUMBER_OF_TEMP_VALUES) {
                    println("Получены данные о температуре: ${temperature.joinToString()}.\n")
                    return Temperature(temperature.first()!!, temperature.last()!!)
                }
                else println("Внесены некорректные данные. Пожалуйста, повторите ввод.\n")
            }
        }
    }

    fun sendMessage(stats: WeatherStationStats) {
        when (stats) {
            is Temperature -> println("Отправка данных о температуре: ${stats.maxTemp}, ${stats.minTemp}.")
            is PrecipitationAmount -> println("Отправка данных об осадках: ${stats.amount}.")
        }
    }
}

private const val NUMBER_OF_TEMP_VALUES = 2
