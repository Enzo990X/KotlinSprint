package org.example.lesson_13

fun main() {
    val phonebook = Phonebook("Денис Семенихин", 88005553535, null)

    phonebook.printRecord()
}

private class Phonebook (val fullName: String, val phoneNumber: Long, val companyName: String?) {

    fun printRecord() {

        println("ФИО: $fullName\nНомер телефона: $phoneNumber\nМесто работы: ${companyName ?: "<не указано>"}")
    }
}