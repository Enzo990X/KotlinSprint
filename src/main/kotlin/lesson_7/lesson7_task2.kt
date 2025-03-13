package org.example.lesson_7

fun main() {
    val codeRange = RANGE_START..RANGE_END
    var code = codeRange.random()
    println("Ваш код авторизации: $code.\nВведите код.")

    var getCode = readln().toInt()

    while (getCode != code) {
        println("Ошибка.\n")
        code = codeRange.random()
        println("Новый код авторизации: $code.\nВведите код.")
        getCode = readln().toInt()
    }
    println("Добро пожаловать!")
}

private const val RANGE_START = 1000
private const val RANGE_END = 9999