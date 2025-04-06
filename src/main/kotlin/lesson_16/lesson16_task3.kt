package org.example.lesson_16

fun main() {
    val user = User("user", "password")

    println("Введите пароль:")
    if (checkPassword(user, readln()))
        println("\nПароль верный.")
    else
        println("\nПароль неверный.")
}


fun checkPassword(user: User, password: String): Boolean {
    return user.getPassword() == password
}

class User (val name: String, private val password: String) {

    fun getPassword(): String = password
}
