package org.example.lesson_18

fun main() {
    val order1 = Order(1)
    val order2 = Order(2)

    order1.addOrder(1, "Зелёные тапочки")
    order2.addOrder(2, listOf("Рис", "Гречка", "Морковь", "Помидоры", "Капуста"))
}

class Order (val id: Int) {

    fun addOrder(id: Int, item: String) {
        println("Заказан товар: $item.")
    }

    fun addOrder(id: Int, item: List<String>) {
        println("Заказан товар: ${item.joinToString(", ")}.")
    }
}