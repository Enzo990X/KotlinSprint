package org.example.lesson_13

fun main() {
    val phonebookList = mutableListOf<Phonebook4>()

    val newContact = Phonebook4("", null, "")
    newContact.addNewContact()
    phonebookList.add(newContact)

    phonebookList.forEach {
        println("ФИО: ${it.fullName}\nНомер телефона: ${it.phoneNumber}\n" +
                "Место работы: ${it.companyName ?: "<не указано>"}")
    }
}

class Phonebook4(var fullName: String, var phoneNumber: Long?, var companyName: String?) {

    fun addNewContact() {
        println("Введите ФИО: ")
        fullName = readln()

        println("Введите номер телефона: ")
        phoneNumber = readln().toLongOrNull()
        while (phoneNumber == null) {
            println("Номер телефона не заполнен. Введите номер телефона: ")
            phoneNumber = readln().toLongOrNull()
        }

        println("Введите место работы: ")
        companyName = readln()
        companyName = companyName?.takeUnless { it.isEmpty() }
    }
}