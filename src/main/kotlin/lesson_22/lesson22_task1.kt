package org.example.lesson_22

fun main() {

    val book1 = RegularBook("Империя ангелов", "Бернар Вербер")
    val book2 = RegularBook("Империя ангелов", "Бернар Вербер")
    val book3 = DataBook("Империя ангелов", "Бернар Вербер")
    val book4 = DataBook("Империя ангелов", "Бернар Вербер")

    println(book1 == book2)
    println(book3 == book4)
}

/*
При сравнении объектов обычных классов возвращается false, потому что сравниваются ссылки на объекты в памяти.
Data class позволяет сравнить между собой свойства объектов, поэтому возвращается true.
*/

class RegularBook(val name: String, val author: String)

data class DataBook(val name: String, val author: String)
