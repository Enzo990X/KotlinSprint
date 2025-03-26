package org.example.lesson_13

fun main() {
    val phonebookList = mutableListOf<Phonebook>()

    val newContact = Phonebook("", "", "")
    newContact.addNewContact()
    phonebookList.add(newContact)

    for (i in phonebookList.indices) {

        if (phonebookList[i].companyName == null) println("ФИО: ${phonebookList[0].fullName}\n" +
                "Номер телефона: ${phonebookList[i].phoneNumber}\nМесто работы: <не указано>")
        else println(            "ФИО: ${phonebookList[i].fullName}\nНомер телефона: ${phonebookList[i].phoneNumber}" +
                "\nМесто работы: ${phonebookList[i].companyName}")
    }
}

private class Phonebook(var fullName: String, var phoneNumber: String, var companyName: String?) {

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
        if (companyName!!.isEmpty()) companyName = null
    }
}

private const val FIRST_SMALL_CHAR = 'a'
private const val LAST_SMALL_CHAR = 'z'
private const val FIRST_BIG_CHAR = 'A'
private const val LAST_BIG_CHAR = 'Z'