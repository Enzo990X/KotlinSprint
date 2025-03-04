package org.example.lesson_4

fun main() {

    val requirements1 = Requirements("Нет", 55, 70, 50, "Любая")
    val requirements2 = Requirements("Есть незначительные", 55, 70, 50, "Да")

    println("Как поживает корабль? Повреждений нет?")
    val currentDamage = readln()
    println("Сколько людей на борту?")
    val currentCrew = readln().toInt()
    println("Сколько ящиков провизии на борту?")
    val currentCargo = readln().toInt()
    println("Как погодка? Благоприятная?")
    val currentWeather = readln()

    val compareDamageR1 = currentDamage == requirements1.damage
    val compareCrewR1 = currentCrew in requirements1.minCrew..requirements1.maxCrew
    val compareCargoR1 = currentCargo > requirements1.cargo

    val compareDamageR2 = currentDamage == requirements2.damage
    val compareCrewR2 = currentCrew == requirements2.maxCrew
    val compareCargoR2 = currentCargo > requirements2.cargo
    val compareWeatherR2 = currentWeather == requirements2.weather

    val comparsionResult1 = compareDamageR1 && compareCrewR1 && compareCargoR1
    val comparisonResult2 = compareDamageR2 && compareCrewR2 && compareCargoR2 && compareWeatherR2


    val readyToTravel = comparsionResult1 || comparisonResult2

    if (readyToTravel) {
        println("Ну вперед, на встречу приключениям!")
    } else {
        println("Не сегодня... [вздыхает...]")
    }
}

class Requirements(val damage: String, val minCrew: Int, val maxCrew: Int, val cargo: Int, val weather: String)


