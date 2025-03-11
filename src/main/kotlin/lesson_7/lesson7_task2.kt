package org.example.lesson_7

fun main() {
    var code = (1000..9999).random()
    println("Ваш код авторизации: $code.\nВведите код.")

        var getCode = readln().toInt()

    while (getCode != code) {
        println("Ошибка.\n")
        code = (1000..9999).random()
        println("Новый код авторизации: $code.\nВведите код.")
        getCode = readln().toInt()
    }
    println ("Добро пожаловать!")

}


