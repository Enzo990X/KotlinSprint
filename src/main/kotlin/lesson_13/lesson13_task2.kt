package org.example.lesson_13

fun main() {
    val phonebook = Phonebook("Денис Семенихин", 88005553535, null)

    phonebook.printRecord()
}

private class Phonebook (val fullName: String, val phoneNumber: Long, val companyName: String?) {

    fun printRecord() {

        if (companyName == null) println("ФИО: $fullName\nНомер телефона: $phoneNumber\nМесто работы: <не указано>")
        else println("ФИО: $fullName\nНомер телефона: $phoneNumber\nМесто работы: $companyName")
    }
}