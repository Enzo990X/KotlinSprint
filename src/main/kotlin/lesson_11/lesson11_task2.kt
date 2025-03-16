package org.example.lesson_11

fun main() {

    val user1 = User2(0, "Alex", "YEF77goo", "barmaglot@harvard.edu")
    val user2 = User2(1, "Bill", "aFR7Pq0P", "bill@hotmail.com")

    user1.printData()
    user1.changePassword()
    user1.getUserBio()
    user2.printData()
    user2.changePassword()
    user2.getUserBio()
}

private class User2(val id: Int, val name: String, var password: String, val email: String, var bio: String = "") {

    fun printData() {
        println("Введите имя пользователя: ")
        var askName = readln()

        while (name != askName) {
            println("Неверное имя. Повторите попытку.")
            askName = readln()
        }

        println(
            "Пользователь №${id + INCREMENT}: ${name}. " +
                    "\nДанные для входа: ${email}, ${password}.\n"
        )
    }

    fun getUserBio(): String {
        println("Осуществите вход в систему.")
        println("Введите почту: ")
        var userMail = readln()
        println("Введите пароль: ")
        var userPassword = readln()

        while (email != userMail || password != userPassword) {
            println("Неверные данные. Повторите попытку.")
            userMail = readln()
            userPassword = readln()
        }

        println("Вход выполнен.\nМожете изменить свою биографию.")
        bio = readln()
        return bio
    }

    fun changePassword(): String {
        println("Введите старый пароль: ")
        var currentPassword = readln()

        while (password != currentPassword) {
            println("Неверный пароль. Повторите попытку.")
            currentPassword = readln()
        }

        println("Введите новый пароль: ")
        val newPassword = readln()
        password = newPassword
        return password
    }
}

private const val INCREMENT = 1