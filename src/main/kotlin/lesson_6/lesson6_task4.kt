package org.example.lesson_6

fun main() {

    val number = (0..9).random()
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