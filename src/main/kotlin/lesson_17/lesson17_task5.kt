package org.example.lesson_17

fun main() {
    val user = OneMoreUser("user", "12345678")
    println(user.password)

    user.password = "87654321"
    user.login = "admin"
}

class OneMoreUser(login: String, password: String) {

    var password = password
        get() {
            return "*".repeat(field.length)
        }
        set(value) {
            println("Вы не можете изменить пароль.")
        }

    var login = login
        set(value) {
            if (value != this.login) {
                println("Логин изменён.")
            }
            field = value
        }
}


