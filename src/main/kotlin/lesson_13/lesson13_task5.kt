package org.example.lesson_13

fun main() {
    val phonebookList = mutableListOf<Phonebook5>()

    val newContact = Phonebook5("", "", "")
    newContact.addNewContact()
    phonebookList.add(newContact)

    phonebookList.forEach { phonebook ->
        println("ФИО: ${phonebook.fullName}\nНомер телефона: ${phonebook.phoneNumber}")
        println("Место работы: ${phonebook.companyName ?: "<не указано>"}")
    }
}

private class Phonebook5(var fullName: String, var phoneNumber: String, var companyName: String?) {

    fun addNewContact() {
        println("Введите ФИО: ")
        fullName = readln()

        println("Введите номер телефона: ")
        phoneNumber = readln()
        while (phoneNumber == "") {
            println("Ошибка. Номер телефона не указан.")
            phoneNumber = readln()
        }

        while (phoneNumber.any { it in FIRST_SMALL_CHAR..LAST_SMALL_CHAR } ||
            phoneNumber.any { it in FIRST_BIG_CHAR..LAST_BIG_CHAR }) {
            println("Ошибка. Номер телефона должен состоять только из цифр.")
            phoneNumber = readln()
        }

        phoneNumber.toLong()

        println("Введите место работы: ")
        companyName = readln()
        companyName?.takeUnless { it.isEmpty() }
    }
}

private const val FIRST_SMALL_CHAR = 'a'
private const val LAST_SMALL_CHAR = 'z'
private const val FIRST_BIG_CHAR = 'A'
private const val LAST_BIG_CHAR = 'Z'