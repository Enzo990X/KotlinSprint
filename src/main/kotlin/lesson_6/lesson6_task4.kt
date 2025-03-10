package org.example.lesson_6

import kotlin.random.Random

fun main() {

    val number = Random.nextInt(10)
    var tryNumber = 5

    while (tryNumber > 0) {
        println("Введите число от 0 до 9")
        val userNumber = readln().toInt()
        if (userNumber == number) {
            println("Это была великолепная игра!\n")
            break
        } else {
            println("Вы не угадали.\nХотя мне всё равно...\n")
        }
        tryNumber--
    }

    println("Загаданное число: $number")
}