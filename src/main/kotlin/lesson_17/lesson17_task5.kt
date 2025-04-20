package org.example.lesson_17

fun main() {
    val user = OneMoreUser("user", "12345678")
    println(user.hidedPassword)

    user.newPassword = "87654321"

    user.newLogin = "admin"
}


class OneMoreUser(var login: String, private val password: String) {

    val hidedPassword: String
        get() {
            return "*".repeat(password.length)
        }

    var newPassword: String = password
        set(value) {
            if (field != value) {
                println("Вы не можете изменить пароль.")
            }
            field = this.password
        }

    var newLogin: String = login
        set(value) {
            if (value != this.login) {
                println("Логин изменён.")
            }
            field = value
        }
}


