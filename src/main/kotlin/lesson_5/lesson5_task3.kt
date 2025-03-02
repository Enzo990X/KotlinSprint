package org.example.lesson_5

fun main() {

    val firstNumber = 7
    val secondNumber = 42

    println("Введите два числа")

    val userFirstNumber = readLine()?.toIntOrNull()
    val userSecondNumber = readLine()?.toIntOrNull()

    if (userFirstNumber == firstNumber && userSecondNumber == secondNumber) {
        println("Вы угадали!")
    }
    else {
        println("Вы не угадали!")
    }
}