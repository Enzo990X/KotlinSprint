package org.example.lesson_9

fun main() {

    val listOfIngredients = mutableListOf<String>()

    repeat(NUMBER_OF_INGREDIENTS) {
        println("Введите ингредиент:")
        var ingredient = readln()
        while (listOfIngredients.contains(ingredient)) {
            println("Такой ингредиент уже есть в рецепте")
            ingredient = readln()
        }
        listOfIngredients.add(ingredient)
    }

    listOfIngredients.sort()
    println(listOfIngredients.joinToString().replaceFirstChar { it.uppercase() } + ".")
}

private const val NUMBER_OF_INGREDIENTS = 5