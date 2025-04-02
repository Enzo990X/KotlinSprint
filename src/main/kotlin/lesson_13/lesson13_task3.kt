package org.example.lesson_13

fun main() {
    val phonebookList = mutableListOf<Phonebook3>(
        Phonebook3("Денис Семенихин", 88005553535, null),
        Phonebook3("Константин Заруцкий", 88125553535, "Апрохим"),
        Phonebook3("Егор Захаров", 88005559887, "Левел"),
        Phonebook3("Иван Иванов", 88005556554, "null"),
        Phonebook3("Петр Сидоров", 88005551234, null))

    val companyList = mutableSetOf<String?>()

    for (phonebook in phonebookList) {
        companyList.add(phonebook.companyName)
    }

    println("Список компаний:")
    for (company in companyList) {
        println(company ?: "<не указано>")
    }
}

class Phonebook3 (val fullName: String, val phoneNumber: Long, val companyName: String?)