package org.example.lesson_8

fun main() {

    val arrayOfIngredients = arrayOf("яйцо", "масло", "сыр", "перец", "томат", "помидор", "салат", "колбаса")
    println(arrayOfIngredients.joinToString())

    println("\nКакой ингредиент Вы хотите заменить?")
    var oldIngredient = readln()

    while (oldIngredient !in arrayOfIngredients) {
        println("Такого ингредиента нет в списке.\nКакой ингредиент Вы хотите заменить?")
        oldIngredient = readln()
    }

    println("На какой ингредиент Вы хотите заменить его?")
    val newIngredient = readln()

    val index = arrayOfIngredients.indexOf(oldIngredient)
    arrayOfIngredients[index] = newIngredient

    println("Готово! Вы сохранили следующий список: ${arrayOfIngredients.joinToString()}")
}