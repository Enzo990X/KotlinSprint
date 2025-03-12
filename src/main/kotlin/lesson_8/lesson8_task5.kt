package org.example.lesson_8

fun main() {

    println("Введите количество ингредиентов в списке: ")
    val listSize = readln().toInt()

    val arrayOfIngredients = Array(listSize) { "" }

    for (i in arrayOfIngredients.indices) {
        println("Введите ${i + INCREMENT} ингредиент: ")
        arrayOfIngredients[i] = readln()
    }
    print("Ваш список ингредиентов: ")
    for (i in arrayOfIngredients.indices) {
        if (i == arrayOfIngredients.lastIndex) {
            print("${arrayOfIngredients[i]}.")
        } else {
            print("${arrayOfIngredients[i]}, ")
        }
    }
}

private const val INCREMENT = 1