package org.example.lesson_4

fun main() {

    val requirements1 = Requirements(false, 55, 70, 50, true)
    val requirements2 = Requirements(true, 55, 70, 50, true)

    println("Как поживает корабль? Повреждений нет?")
    val askDamage = readln()
    val isDamaged = askDamage != "Нет"

    println("Сколько людей на борту?")
    val currentCrew = readln().toInt()

    println("Сколько ящиков провизии на борту?")
    val currentCargo = readln().toInt()

    println("Как погодка? Благоприятная?")
    val askWeather = readln()
    val currentWeather = askWeather == "Да"

    val compareDamageR1 = isDamaged == requirements1.hasDamage
    val compareCrewR1 = currentCrew in requirements1.minCrew..requirements1.maxCrew
    val compareCargoR1 = currentCargo > requirements1.cargo

    val compareDamageR2 = isDamaged == requirements2.hasDamage
    val compareCrewR2 = currentCrew == requirements2.maxCrew
    val compareCargoR2 = currentCargo > requirements2.cargo
    val compareWeatherR2 = currentWeather == requirements2.isWeatherGood

    val comparisonResult1 = compareDamageR1 && compareCrewR1 && compareCargoR1
    val comparisonResult2 = compareDamageR2 && compareCrewR2 && compareCargoR2 && compareWeatherR2


    val readyToTravel = comparisonResult1 || comparisonResult2

    if (readyToTravel) {
        println("Ну вперед, на встречу приключениям!")
    } else {
        println("Не сегодня... [вздыхает...]")
    }
}

class Requirements(val hasDamage: Boolean, val minCrew: Int, val maxCrew: Int, val cargo: Int, val isWeatherGood: Boolean)


