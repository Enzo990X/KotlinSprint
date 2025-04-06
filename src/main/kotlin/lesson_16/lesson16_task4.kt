package org.example.lesson_16

fun main() {
    val order = Order(1, "New")

    order.changeStatus(requestChangeOrderStatus())
    println("Статус заказа изменен на: ${order.status}.")
}

fun requestChangeOrderStatus(): String {
    println("Получена заявка на изменение статуса заказа. Новый статус: ")
    val newStatus = readln()
    return newStatus
}

class Order (private val id: Int, var status: String) {

    fun changeStatus(newStatus: String) {
        status = newStatus
    }
}

