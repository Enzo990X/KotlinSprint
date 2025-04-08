package org.example.lesson_17

fun main() {
    val folder1 = Folder(true, "Папка", 10 )
    val folder2 = Folder(false, "Папка", 5 )

    println(folder1.name)
    println(folder1.numberOfFiles)
    println(folder2.name)
    println(folder2.numberOfFiles)
}

class Folder(private val secret: Boolean, name: String, numberOfFiles: Int) {

    var name: String = name
        get() = if (this.secret) "Скрытая папка"
        else field

    var numberOfFiles: Int = numberOfFiles
        get() = if (this.secret) SECRET_NUMBER_OF_FILES
        else field
}

private const val SECRET_NUMBER_OF_FILES = 0
