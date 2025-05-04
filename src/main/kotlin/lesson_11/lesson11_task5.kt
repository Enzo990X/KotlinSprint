package org.example.lesson_11

fun main() {

    val forumBuilder = Forum()
    println("Добро пожаловать на форум ${forumBuilder.name}!\n")

    println("Хотите создать нового пользователя?")
    askForNewUser(forumBuilder)
    askForNewPost(forumBuilder)

    forumBuilder.printThread()
}

fun askForNewUser(forumBuilder: Forum) {
        var answerAboutNewUser = readln().lowercase()

    while (answerAboutNewUser == "да") {

        println("Введите имя пользователя: ")
        val name = readln()
        forumBuilder.createNewUser(name)
        println("\nХотите создать нового пользователя?")
        answerAboutNewUser = readln()
    }
}

fun askForNewPost(forumBuilder: Forum) {

    if (forumBuilder.users.isEmpty()) {
        println("Список пользователей пуст. Хотите создать нового пользователя?")
        val createUserResponse = readln().lowercase()
        if (createUserResponse == "да") {
            askForNewUser(forumBuilder)
        } else {
            println("Невозможно создать пост без пользователей.")
            return
        }
    }

    println("\nХотите написать новый пост?")
    var answerAboutNewPost = readln().lowercase()

    while (answerAboutNewPost == "да") {

        println("Введите имя пользователя: ")
        var userName = readln()
        var userId: Int? = null
        while (userId == null) {
            val user = forumBuilder.users.find { it.name == userName }
            if (user != null) {
                userId = user.userId
            } else {
                println("Пользователь не найден. Повторите попытку.")
                userName = readln()
            }
        }

        println("Введите текст поста: ")
        val message = forumBuilder.createNewMessage(text = readln(), userId = userId)

        println("\nХотите написать новый пост?")
        answerAboutNewPost = readln()
    }
}

class Forum(
    var name: String = "Песочница",
    val users: MutableList<ForumUser> = mutableListOf(),
    private val messages: MutableList<Message> = mutableListOf(),
) {

    companion object {
        var userId: Int = 0
        var messageId: Int = 0
    }

    fun createNewUser(name: String): ForumUser {

        if (users.any { it.name == name }) {
            println("Пользователь с таким именем уже существует.")
            return ForumUser(name, userId)
        }

        val newUserId = userId++
        val user = ForumUser(name, newUserId)
        users.add(user)
        return user
    }

    fun createNewMessage(text: String, userId: Int): Message {
        val newMessageId = messageId++
        val newMessage = Message(text, userId, newMessageId)
        messages.add(newMessage)
        return newMessage
    }

    fun printThread() {
        println(messages.joinToString("\n") { message ->
            "${users.first { users -> users.userId == message.userId }.name}: ${message.text}"
        })
    }
}

class ForumUser(
    val name: String,
    val userId: Int,
)

class Message(
    var text: String = "",
    var userId: Int,
    var messageId: Int,
)
