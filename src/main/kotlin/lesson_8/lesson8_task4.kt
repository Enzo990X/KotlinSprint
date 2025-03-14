package org.example.lesson_8

fun main() {

    val arrayOfIngredients = arrayOf("яйцо", "масло", "сыр", "перец", "томат", "помидор", "салат", "колбаса")
    println(arrayOfIngredients.joinToString())

    println("\nКакой ингредиент Вы хотите заменить?")
    var oldIngredient = readln()
    var index = arrayOfIngredients.indexOf(oldIngredient)

    while (index == -1) {
        println("Такого ингредиента нет в списке.\nКакой ингредиент Вы хотите заменить?")
        oldIngredient = readln()
        index = arrayOfIngredients.indexOf(oldIngredient)
    }

    println("На какой ингредиент Вы хотите заменить его?")
    val newIngredient = readln()

    arrayOfIngredients[index] = newIngredient

    println("Готово! Вы сохранили следующий список: ${arrayOfIngredients.joinToString()}")
}