package org.example.lesson_21

import java.io.File
import java.util.*
import java.time.LocalDate


fun main() {

    val currentDate = LocalDate.now()
    if (lastResetDate != currentDate) {
        wordsCounter = ZERO
        lastResetDate = currentDate
    }

    val dictionary = File("dictionary.txt")

    updateDictionary(dictionary)
}

fun updateDictionary(dictionary: File) {
    println("Хотите пополнить Ваш словарь?")
    val enterAnswer = readln()

    if (enterAnswer.equals("да", ignoreCase = true)) {
        wordsCounter = addWord(dictionary)
    }

    while (true) {
        when (wordsCounter) {
            ZERO -> {
                println("Словарь остался голодным и ему очень грустно.\nДавай это исправим? ")
                val returnAnswer = readln()

                if (returnAnswer.equals("да", ignoreCase = true)) {
                    wordsCounter = addWord(dictionary)
                } else {
                    println("Ну и ладно.")
                    break
                }
            }

            in ONE..FOUR -> {
                println("Словарь не наелся.\nДавай это исправим? ")
                val returnAnswer = readln()

                if (returnAnswer.equals("да", ignoreCase = true)) {
                    wordsCounter = addWord(dictionary)
                } else {
                    println("Не очень-то и хотелось.")
                    break
                }
            }

            else -> {
                println("\nСловарь стал сытым и довольным.")
                break
            }
        }
    }
}

fun addWord(dictionary: File): Short {

    println("\nВведите новое слово: ")
    dictionary.writeWordToDictionary(dictionary)
    wordsCounter++

    println("\nХотите ввести ещё одно слово?")
    var answer = readln()

    while (answer.equals("да", ignoreCase = true)) {
        println("\nВведите новое слово: ")
        dictionary.writeWordToDictionary(dictionary)
        wordsCounter++

        println("\nХотите ввести ещё одно слово?")
        answer = readln()
    }

    return wordsCounter
}

fun File.writeWordToDictionary(dictionary: File) {

    val newWord = readln().lowercase(Locale.getDefault())

    if (!dictionary.exists()) dictionary.createNewFile()

    val existingContent = this.readText(Charsets.UTF_8)
    val updatedContent = "$newWord\n$existingContent"
    writeText(updatedContent, Charsets.UTF_8)
}

var wordsCounter: Short = 0
private var lastResetDate: LocalDate? = null

private const val ZERO: Short = 0
private const val ONE: Short = 1
private const val FOUR: Short = 4
