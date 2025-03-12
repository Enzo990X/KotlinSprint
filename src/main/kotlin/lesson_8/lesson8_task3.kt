package org.example.lesson_8

fun main() {

    val arrayOfIngredients = arrayOf("яйцо", "масло", "сыр", "перец", "томат", "помидор", "салат", "колбаса")

    println("Наличие какого ингредиента в рецепте Вас интересует?")
    val userIngredient = readln()

    if (userIngredient in arrayOfIngredients) {
        println("Ингредиент $userIngredient в рецепте есть")
    }
    else {
        println("Такого ингредиента в рецепте нет")
    }
}
