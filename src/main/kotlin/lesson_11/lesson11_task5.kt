package org.example.lesson_11

fun main() {

    val forumBuilder = Forum.Builder()
    println("Добро пожаловать на форум ${forumBuilder.name}!")

    println("Хотите создать нового пользователя?")
    var answerAboutNewUser = readln()
    while (answerAboutNewUser == "Да" || answerAboutNewUser == "да") {

        println("Введите имя пользователя: ")
        val name = readln()
        println("Введите дату рождения пользователя: ")
        val birthday = readln()
        println("Введите описание пользователя: ")
        val description = readln()
        forumBuilder.createNewUser(name, birthday, description)
        println("\nХотите создать нового пользователя?")
        answerAboutNewUser = readln()
    }

    println("Хотите написать новый пост?")
    var answerAboutNewPost = readln()
    while (answerAboutNewPost == "Да" || answerAboutNewPost == "да") {

        println("Введите имя пользователя: ")
        var userName = readln()
        var userId: Int? = null
        while (userId == null) {
            val user = forumBuilder.users.find { it.name == userName }
            if (user != null) {
                userId = user.newUserId
            } else {
                println("Пользователь не найден. Повторите попытку.")
                userName = readln()
            }
        }

        println("Введите текст поста: ")
        val message = forumBuilder.createNewMessage(text = readln(), userId = userId)

        println("Хотите написать новый пост?")
        answerAboutNewPost = readln()
    }

    println(forumBuilder.printThread(forumBuilder.users, forumBuilder.messages))
}


private class Forum(
    val name: String,
    val users: MutableList<ForumUser> = mutableListOf(),
    val messages: MutableList<Message> = mutableListOf(),

    ) {

    class Builder {
        var name: String = "Песочница"
        val users: MutableList<ForumUser> = mutableListOf()
        val messages: MutableList<Message> = mutableListOf()

        fun createNewUser(name: String, dateOfBirth: String, bio: String = ""): ForumUser {
            val user = ForumUser(name, dateOfBirth, bio)
            users.add(user)
            return user
        }

        fun createNewMessage(text: String, userId: Int): Message {
            Message.messageId++
            val message = Message(text, userId, Message.messageId)
            messages.add(message)
            return message
        }

        fun printThread(users: List<ForumUser>, messages: MutableList<Message>): String {
            return messages.joinToString("\n") { message ->
                "${users.first { it.newUserId == message.userId }.name}: ${message.text}"
            }
        }


        fun setName(name: String): Builder {
            this.name = name
            return this
        }

        fun build(): Forum {
            return Forum(name)
        }
    }
}


class ForumUser(
    val name: String,
    val dateOfBirth: String,
    var bio: String = "",
) {
    companion object {
        var userId: Int = 0
    }

    val newUserId: Int = userId++
}

class Message(
    var text: String = "",
    var userId: Int,
    var messageId: Int,
) {
    companion object {
        var messageId: Int = 0
    }
}