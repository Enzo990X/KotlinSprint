package org.example.lesson_3

import java.util.*

fun main() {

    val h = Calendar.getInstance().get(Calendar.HOUR_OF_DAY)
    val userName = System.getProperty("user.name")

    val greetingMessage = when (h) {
        in 6..10 -> "Доброе утро, $userName"
        in 11..17 -> "Добрый день, $userName"
        in 18..22 -> "Добрый вечер, $userName"
        else -> "Не спишь, $userName?"
    }

    println(greetingMessage)
/*
    //По заданию
    val userName = "Flint"
    var greetingMessage = "Добрый день, $userName"
    println(greetingMessage)

    greetingMessage = "Добрый вечер, $userName"
    println(greetingMessage)
*/

}