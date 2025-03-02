package org.example.lesson_4

fun main() {

    val orderedTablesForToday = 13
    val orderedTablesForTomorrow = 9

    val leftTablesForToday = (orderedTablesForToday < TOTAL_NUMBER_OF_TABLES)
    val leftTablesForTomorrow = (orderedTablesForTomorrow < TOTAL_NUMBER_OF_TABLES)

    println("[Доступность столиков на сегодня: $leftTablesForToday]\n[Доступность столиков на завтра: $leftTablesForTomorrow]")
}

const val TOTAL_NUMBER_OF_TABLES = 13