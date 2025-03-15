package org.example.lesson_9

fun main() {

    val setOfIngredients = mutableSetOf<String>()

    repeat(NUMBER_OF_INGREDIENTS) {
        while (true) {
            println("Введите ингредиент:")
            val ingredient = readln()
            if (setOfIngredients.add(ingredient)) break
            println("Такой ингредиент уже есть в рецепте")
        }
    }

    val sortedIngredients = setOfIngredients.sorted()
    println(sortedIngredients.joinToString().replaceFirstChar { it.uppercase() } + ".")
}

private const val NUMBER_OF_INGREDIENTS = 5