package org.example.lesson_17

fun main() {
    val folder1 = Folder("Папка", 10, true)
    val folder2 = Folder("Папка", 5, false)

    println(folder1.name)
    println(folder1.numberOfFiles)
    println(folder2.name)
    println(folder2.numberOfFiles)
}

class Folder(var name: String, var numberOfFiles: Int, private val secret: Boolean) {

    init {
        if (this.secret) {
            this.name = "Скрытая папка"
            this.numberOfFiles = SECRET_NUMBER_OF_FILES
        }
    }
}

private const val SECRET_NUMBER_OF_FILES = 0
