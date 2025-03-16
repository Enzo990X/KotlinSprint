package org.example.lesson_11

fun main() {

    val user1 = User(0, "Alex", "YEF77goo", "barmaglot@harvard.edu")
    val user2 = User(1, "Bill", "aFR7Pq0P", "bill@hotmail.com")

    println("Пользователь №${user1.id + INCREMENT}: ${user1.login}. " +
            "\nДанные для входа: ${user1.password}, ${user1.email}.\n")
    println("Пользователь №${user2.id + INCREMENT}: ${user2.login}. " +
            "\nДанные для входа: ${user2.password}, ${user2.email}.\n")
}

class User(val id: Int, val login: String, val password: String, val email: String)

private const val INCREMENT = 1