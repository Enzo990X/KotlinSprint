package org.example.lesson_19

fun main() {
    val item1 = Item("Кроссовки", 1, 1)
    val item2 = Item("Степлер", 2, 2)
    val item3 = Item("Швабра", 3, 3)

    item1.showInfo(1)
    item2.showInfo(2)
    item3.showInfo(3)
}

enum class Categories(val categoryId: Int) {
    CLOTHES(1) {
        override fun getName(): String = "Одежда"
    },
    STATIONARY(2) {
        override fun getName(): String = "Канцтовары"
    },
    OTHER(3) {
        override fun getName(): String = "Прочее"
    };

    abstract fun getName(): String
}

class Item(val name: String, val id: Int, var category: Int) {

    fun showInfo(category: Int) {
        when (category) {
            1 -> println("Название: $name, категория: ${Categories.CLOTHES.getName()}")
            2 -> println("Название: $name, категория: ${Categories.STATIONARY.getName()}")
            3 -> println("Название: $name, категория: ${Categories.OTHER.getName()}")
        }
    }
}