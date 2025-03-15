package org.example.lesson_10

fun main() {

    println("Создание учётной записи")
    println("Введите имя пользователя: ")
    var userName = readln()
    while (!checkUserName(userName)) {
        println("Размер имени должен быть не менее 4 символов")
        userName = readln()
    }

    println("Введите пароль: ")
    var password = readln()
    while (!checkPassword(password)) {
        println("Размер пароля должен быть не менее 4 символов")
        password = readln()
    }

    println("[вздыхает...]Ваши данные проверены, и о, чудо, они верны...\nВам разрешен вход")

}

fun checkUserName(userName: String): Boolean {
    return userName.length >= MIN_SIZE
}

fun checkPassword(password: String): Boolean {
    return password.length >= MIN_SIZE
}

private const val MIN_SIZE = 4