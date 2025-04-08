package org.example.lesson_18

fun main() {
    val order1 = Order()
    val order2 = Order()

    order1.addOrder(1, "Зелёные тапочки")
    order2.addOrder(2, listOf("Рис", "Гречка", "Морковь", "Помидоры", "Капуста"))
}

class Order {

    fun addOrder(id: Int, item: String) {
        println("Заказан товар: $item.")
    }

    fun addOrder(id: Int, item: List<String>) {
        println("Заказан товар: ${item.joinToString(", ")}.")
    }
}