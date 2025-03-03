package org.example.lesson_5

import java.util.Calendar

fun main() {

    println("Введите год рождения")
    val yearOfBirth = readln().toInt()

    val userAge = Calendar.getInstance().get(Calendar.YEAR) - yearOfBirth

    if (userAge >= AGE_LIMIT) {
        println("Показать экран со скрытым контентом")
    }
    else {
        println("Доступ запрещен")
    }
}

const val AGE_LIMIT = 18