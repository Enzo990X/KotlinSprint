package org.example.lesson_8

fun main() {

    val arrayOfIngredients = arrayOf("яйцо", "масло", "сыр", "перец", "томат", "помидор", "салат", "колбаса")

    println("Наличие какого ингредиента в рецепте Вас интересует?")
    val userIngredient = readln()

    var isPresent = false
    for (ingredient in arrayOfIngredients) {
        if (ingredient == userIngredient) {
            isPresent = true
        }
    }

    if (isPresent) {
        println("Ингредиент $userIngredient в рецепте есть")
    }
    else {
        println("Такого ингредиента в рецепте нет")
    }
}