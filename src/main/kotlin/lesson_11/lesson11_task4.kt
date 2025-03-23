package org.example.lesson_11

import java.io.File

fun main() {

    val recipe = Recipe(
        "Бургер с грибами и сыром", File("path/to/image.jpg"), listOf(
            Pair(Ingredient("Творог", "г"), 350f),
            Pair(Ingredient("Куриное яйцо", "шт"), 2f),
            Pair(Ingredient("Пшеничная мука", "ст.л."), 6f),
            Pair(Ingredient("Подсолнечное масло", "ст.л."), 5f),
            Pair(Ingredient("Сахар", "ст.л."), 2f),
        ),
        "1. В глубокой миске смешайте говяжий фарш, лук, чеснок, соль и перец.\n" +
                "Разделите фарш на 4 равные части и сформируйте котлеты.\n" +
                "2. Разогрейте сковороду на среднем огне.\n" +
                "Обжаривайте котлеты с каждой стороны в течение 4-5 минут или до желаемой степени прожарки.\n" +
                "3. В то время как котлеты готовятся, подготовьте булочки.\n" +
                "Разрежьте их пополам и обжарьте на сковороде до золотистой корочки."
    )

    val ingredientQuantities = recipe.calculatePortions()
    println("Для приготовления ${recipe.name} Вам понадобится:")
    ingredientQuantities.forEach() { println("${it.key.name} - ${it.value} ${it.key.unit}") }
    println("\nСпособ приготовления:\n${recipe.steps}\n")

}

private data class Ingredient(
    val name: String,
    val unit: String,
)

private class Recipe(
    val name: String,
    val recipeImage: File,
    val ingredients: List<Pair<Ingredient, Float>>,
    val steps: String,
) {


    fun calculatePortions(): Map<Ingredient, Float> {

        println("Сколько порций Вы хотите приготовить?")
        val numberOfPortions = readln().toFloat()

        val ingredientQuantities = mutableMapOf<Ingredient, Float>()
        ingredients.forEach { (ingredient, quantity) ->
            val quantityForNumPortions = quantity * numberOfPortions
            ingredientQuantities[ingredient] = quantityForNumPortions
        }
        return ingredientQuantities
    }
}

private class RecipeCategory(
    val name: String,
    val recipeCategoryImage: File,
    val recipes: List<Recipe>,
)
