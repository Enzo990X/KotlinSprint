package org.example.lesson_19

fun main() {

    println("Сколько человек Вы хотите внести в базу?")
    val numberOfNewRecords = readInput()

    val database = mutableListOf<Pair<String, String>>()

    repeat(numberOfNewRecords) {
        println("Введите полное имя в формате Фамилия Имя Отчество (через пробел):")
        val fullName = readNameInput()

        println("Укажите пол (м/ж):")
        val gender = readGender()

        database.add(Pair(fullName, gender))
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

    while (input.split(" ").size != 3) {
        println("Ошибка: введите полное имя через пробел.")
        input = readln()
    }

    while (input.split(" ").all { it.isNotEmpty() && !it[0].isUpperCase() }) {
    println("Ошибка: введите каждое слово с заглавной буквы.")
        input = readln()
    }

    return input
}

fun readGender(): String {
    var input = readln()

    while (!input.equals("м", ignoreCase = true) && !input.equals("ж", ignoreCase = true)) {
        println("Ошибка. Введите м или ж.")
        input = readln()
    }

    when (input){
        Gender.MALE.shortGender -> input = "пол: мужской"
        Gender.FEMALE.shortGender -> input =  "пол: женский"
    }

    return input
}

enum class Gender (val shortGender: String) {
    MALE("м"),
    FEMALE("ж"),
}
