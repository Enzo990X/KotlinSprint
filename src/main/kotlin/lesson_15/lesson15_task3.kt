package org.example.lesson_15

fun main() {
    val user = User("user")
    val admin = Admin("admin")
    user.readTopic("topic")
    user.writePost("post")
    admin.readTopic("topic")
    admin.writePost("post")
    admin.removePost("post")
    admin.removeUser("user")
}

abstract class ForumUsers (val login: String) {

    open fun readTopic(topic: String) {
        println("$login читает тему $topic.")
    }

    open fun writePost(post: String) {
        println("$login пишет $post.")
    }
}

class Admin(login: String): ForumUsers(login) {

    override fun readTopic(topic: String) {
        println("$login читает тему $topic.")
    }

    override fun writePost(post: String) {
        println("$login пишет $post.")
    }

    fun removePost(post: String) {
        println("Администратор $login удаляет сообщение $post.")
    }

    fun removeUser(user: String) {
        println("Администратор $login удаляет пользователя $user.")
    }
}

class User(login: String): ForumUsers(login) {

    override fun readTopic(topic: String) {
        println("$login читает тему $topic.")
    }

    override fun writePost(post: String) {
        println("$login пишет $post.")
    }
}
