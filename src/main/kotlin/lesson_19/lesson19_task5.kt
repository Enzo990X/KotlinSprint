package org.example.lesson_19

fun main() {

    println("Сколько человек Вы хотите внести в базу?")
    val numberOfNewRecords = readInput()

    val database = mutableListOf<Pair<String, Gender>>()

    repeat(numberOfNewRecords) {
        println("Введите полное имя в формате Фамилия Имя Отчество (через пробел):")
        val fullName = readNameInput()

        println("Укажите пол (м/ж):")
        val gender = readGenderInput()

        when (gender) {
            "м" -> database.add(Pair(fullName, Gender.MALE))
            "ж" -> database.add(Pair(fullName, Gender.FEMALE))
        }

        println("Данные внесены.\n")
    }

    println("Внесение завершено.")
}

fun readInput(): Int {
    while (true) {
        val input = readln()
        if (input.isEmpty()) {
            println("Ошибка: пустая строка. Пожалуйста, введите число.")
            continue
        }

        try {
            return input.toInt()
        } catch (e: NumberFormatException) {
            println("Ошибка: введите действительное число.")
        }
    }
}

fun readNameInput(): String {

    var input = readln()
    while (input.isEmpty()) {
        println("Ошибка: пустая строка. Повторите ввод.")
        input = readln()
    }

    while (input.split(" ").size != FULLNAME) {
        println("Ошибка: введите полное имя через пробел.")
        input = readln()
    }

    input = input.split(" ")
        .joinToString(" ") { it.lowercase().replaceFirstChar { char -> char.uppercase() } }

    return input
}

fun readGenderInput(): String {
    var input = readln()

    while (!input.equals("м", ignoreCase = true) && !input.equals("ж", ignoreCase = true)) {
        println("Ошибка. Введите м или ж.")
        input = readln()
    }

    return input
}

enum class Gender {
    MALE,
    FEMALE,
}

const val FULLNAME = 3
