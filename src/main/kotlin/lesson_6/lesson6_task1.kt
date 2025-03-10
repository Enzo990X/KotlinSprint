package org.example.lesson_6

fun main() {

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
}