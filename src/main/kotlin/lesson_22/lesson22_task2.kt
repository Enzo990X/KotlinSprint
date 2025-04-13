package org.example.lesson_22


fun main() {

    val book1 = RegularBook1("Империя ангелов", "Бернар Вербер")
    val book2 = DataBook1("Империя ангелов", "Бернар Вербер")

    println(book1)
    println(book2)
}

/*
Первое - строковое представление объекта по умолчанию.
Второе - строковое представление объекта, созданное функцией toString().
 */


class RegularBook1(val name: String, val author: String)

data class DataBook1(val name: String, val author: String)