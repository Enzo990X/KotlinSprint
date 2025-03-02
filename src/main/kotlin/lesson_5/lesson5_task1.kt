package org.example.lesson_5

fun main() {

    val correctAnswer = 42

    println("Для продолжения авторизации решите пример: 40 + 2 = ?")

    val answer = readln().toInt()
    val message = if (answer == correctAnswer) "Добро пожаловать!" else "Доступ запрещен."

    println(message)

}