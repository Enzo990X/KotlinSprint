package org.example.lesson_5

import kotlin.random.Random

fun main() {

    val firstNumber = Random.nextInt(43)
    val secondNumber = Random.nextInt(43)
    val thirdNumber = Random.nextInt(43)
    val generatedNumbers = listOf(firstNumber, secondNumber, thirdNumber)

    println("Введите три числа от 0 до 42")
    val enteredNumber1 = readln().toInt()
    val enteredNumber2 = readln().toInt()
    val enteredNumber3 = readln().toInt()
    val enteredNumbers = listOf(enteredNumber1, enteredNumber2, enteredNumber3)

    val lottery = generatedNumbers.intersect(enteredNumbers.toSet())

    val jackpot = lottery.size == 3
    val halfPot = lottery.size == 2
    val niceTry = lottery.size == 1

    println(
        when {
            jackpot -> "[меланхолический вздох...] Вы выиграли, хотя это не приносит мне радости...\n" +
                    "Но Вы, наверное, об этом не заботитесь."

            halfPot -> "[вздох...] Две руки, две ноги, два глаза, два уха и два правильных ответа.\n" +
                    "Кажется, я знаю Ваше счастливое число."

            niceTry -> "Ваши данные проверены, и о, чудо, Вы ткнули пальцем в небо и попали в Солнце.\n" +
                    "Один правильный ответ."

            else -> {
                "Вы проиграли.\nХотя мне всё равно..."
            }
        }
    )

    println("\n[вздыхает...] Если Вам так уж надо, в конце концов...\nВот: $firstNumber, $secondNumber, $thirdNumber")

}