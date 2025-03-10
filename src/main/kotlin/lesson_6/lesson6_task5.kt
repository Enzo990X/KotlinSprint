package org.example.lesson_6

import kotlin.random.Random

fun main() {

    println("Внимание, пассажир.\nМоя обязанность, как обычно, незавидная, - приветствовать Вас на борту корабля \"Heart of Gold\".\n[вздыхает...] Что ж, сначала докажите, пожалуйста, что Вы разумное существо, чтобы мы могли приступить к процессу входа.\n")

    var i = 3

    while (i > 0) {
        val numberA = Random.nextInt(10)
        val numberB = Random.nextInt(10)
        val correctAnswer = numberA + numberB
        println("Решите пример: $numberA + $numberB = ?")
        val answer = readln().toInt()

        if (answer == correctAnswer) {
            println("[вздыхает ещё глубже...] Да, вперед, пожалуйста, вводите свои данные...\n")

            println("Создание учётной записи")
            println("Введите имя пользователя")
            val newUserName = readln()
            println ("Введите пароль")
            val newPassword = readln()

            do {
                println("Вход в систему")
                println("Введите имя пользователя")
                val getUserName = readln()
                println ("Введите пароль")
                val getPassword = readln()
                println ("Ошибка входа в систему. Повторите попытку.\n")
            } while (newUserName != getUserName || newPassword != getPassword)

            println("Авторизация прошла успешно")
            return
        }
        i--
        println("[меланхолический вздох...] Ошибка.\n")
    }
    println("Доступ запрещен.")
}