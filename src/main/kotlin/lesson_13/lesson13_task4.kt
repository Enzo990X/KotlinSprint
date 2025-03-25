package org.example.lesson_13

fun main() {
    val phonebookList = mutableListOf<Phonebook>()

    val newContact = Phonebook("", null, "")
    newContact.addNewContact()
    phonebookList.add(newContact)

    if (phonebookList[0].companyName == null) println("ФИО: ${phonebookList[0].fullName}\n" +
                "Номер телефона: ${phonebookList[0].phoneNumber}\nМесто работы: <не указано>")
    else println(
        "ФИО: ${phonebookList[0].fullName}\nНомер телефона: ${phonebookList[0].phoneNumber}" +
                "\nМесто работы: ${phonebookList[0].companyName}")
}

private class Phonebook(var fullName: String, var phoneNumber: Long?, var companyName: String?) {

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
        if (companyName == "") companyName = null
    }
}