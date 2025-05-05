package org.example.lesson_19

fun main() {

    println("Сколько человек Вы хотите внести в базу?")
    val numberOfNewRecords = readInput()

    val database = mutableListOf<Person>()

    repeat(numberOfNewRecords) {
        println("Введите полное имя в формате Фамилия Имя Отчество (через пробел):")
        val fullNameInput = readNameInput()

        println("Укажите пол (м/ж):")
        val genderInput = readGenderInput()

        when (genderInput) {
            "м" -> database.add(Person(fullNameInput, Gender.MALE))
            "ж" -> database.add(Person(fullNameInput, Gender.FEMALE))
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

class Person(val fullName: String, val gender: Gender)

enum class Gender {
    MALE,
    FEMALE,
}

const val FULLNAME = 3
