package org.example.lesson_5

import kotlin.random.Random

fun main() {

    val firstNumber = Random.nextInt(43)
    val secondNumber = Random.nextInt(43)
    val thirdNumber = Random.nextInt(43)

    println("Введите три числа от 0 до 42")
    val enteredNumber1 = readln().toInt()
    val enteredNumber2 = readln().toInt()
    val enteredNumber3 = readln().toInt()

    val compareNumber1 = firstNumber == enteredNumber1 || firstNumber == enteredNumber2 || firstNumber == enteredNumber3
    val compareNumber2 =
        secondNumber == enteredNumber2 || secondNumber == enteredNumber1 || secondNumber == enteredNumber3
    val compareNumber3 = thirdNumber == enteredNumber3 || thirdNumber == enteredNumber1 || thirdNumber == enteredNumber2

    val jackpot = compareNumber1 && compareNumber2 && compareNumber3
    val halfPot =
        compareNumber1 && compareNumber2 || compareNumber2 && compareNumber3 || compareNumber1 && compareNumber3
    val niceTry = compareNumber1 || compareNumber2 || compareNumber3

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