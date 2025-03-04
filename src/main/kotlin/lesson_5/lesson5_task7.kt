package org.example.lesson_5

fun main() {

    println("Далеко собрался?")
    val distance = readln().toFloat()

    println("Насколько конь прожорливый?")
    val fuelConsumption = readln().toFloat()

    println("Овёс нынче дорог?")
    val fuelPrice = readln().toFloat()

    val fuelNeeded = distance * fuelConsumption / DIVIDER

    println("Необходимое количество топлива: ${String.format("%.2f", fuelNeeded)} литров")

    val fuelCost = fuelNeeded * fuelPrice

    println("Стоимость топлива: ${String.format("%.2f", fuelCost)}")

}

const val DIVIDER = 100