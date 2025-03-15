package org.example.lesson_9

fun main() {

    val listOfIngredients = (1..NUMBER_OF_INGREDIENTS).map {
        println("Введите ингредиент:")
        readln()
    }.sorted()

    print("Список ингредиентов: " + listOfIngredients.joinToString() + ".\n")
}

private const val NUMBER_OF_INGREDIENTS = 5