package org.example.lesson_20

fun main() {
    val user = User("Антон")

    val greeting = { user: User -> println("С наступающим Новым Годом, ${user.username}!") }
    greeting(user)
}

class User(val username: String)