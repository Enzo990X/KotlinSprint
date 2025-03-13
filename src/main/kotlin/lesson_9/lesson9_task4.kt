package org.example.lesson_9

fun main() {

    val listOfIngredients = mutableListOf<String>()

    repeat(NUMBER_OF_INGREDIENTS) {
        println("Введите ингредиент:")
        val ingredient = readln()
        listOfIngredients.add(ingredient)
    }

    listOfIngredients.sort()
    print("Список ингредиентов: " + listOfIngredients.joinToString() + ".\n")
}

private const val NUMBER_OF_INGREDIENTS = 5