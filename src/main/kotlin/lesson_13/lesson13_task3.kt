package org.example.lesson_13

fun main() {
    val phonebookList = mutableListOf<Phonebook>(
        Phonebook("Денис Семенихин", 88005553535, null),
        Phonebook("Константин Заруцкий", 88125553535, "Апрохим"),
        Phonebook("Егор Захаров", 88005559887, "Левел"),
        Phonebook("Иван Иванов", 88005556554, "null"),
        Phonebook("Петр Сидоров", 88005551234, null))

    val companyList = mutableSetOf<String?>()

    for (phonebook in phonebookList) {
        companyList.add(phonebook.companyName)
    }

    println("Список компаний:")
    for (company in companyList) {
        println(company ?: "<не указано>")
    }
}

private class Phonebook (val fullName: String, val phoneNumber: Long, val companyName: String?)