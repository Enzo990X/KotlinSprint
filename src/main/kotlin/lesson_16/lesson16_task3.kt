package org.example.lesson_16

fun main() {
    val user = User("user", "password")

    println("Введите пароль:")
    if (user.checkPassword(readln()))
        println("\nПароль верный.")
    else
        println("\nПароль неверный.")
}

class User (val name: String, private val password: String) {

    fun checkPassword(password: String): Boolean {
        return this.password == password
    }
}
