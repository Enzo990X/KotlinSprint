package org.example.lesson_18

fun main() {
    val order1 = Order(1)
    val order2 = Order(2)

    order1.addOrder("Зелёные тапочки")
    order2.addOrder(listOf("Рис", "Гречка", "Морковь", "Помидоры", "Капуста"))
}

class Order (val id: Int) {

    fun addOrder(item: String) {
        println("Заказан товар: $item.")
    }

    fun addOrder(item: List<String>) {
        println("Заказан товар: ${item.joinToString(", ")}.")
    }
}