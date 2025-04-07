package org.example.lesson_16

fun main() {
    val order = Order(1, "New")

    order.requestChangeOrderStatus()
    println("Статус заказа изменен на: ${order.status}.")
}

class Order (private val id: Int, var status: String) {

    private fun changeStatus(newStatus: String) {
        status = newStatus
    }

    fun requestChangeOrderStatus() {
        println("Получена заявка на изменение статуса заказа. Новый статус: ")
        val newStatus = readln()
        changeStatus(newStatus)
    }
}

