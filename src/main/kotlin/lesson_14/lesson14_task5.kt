package org.example.lesson_14

fun main() {

    val chat = Chat()

    askForNewMessage(chat)
    chat.printChat()
}

fun askForNewMessage(chat: Chat) {

    do {
        println("Хотите написать сообщение или добавить комментарий?")
        val answer = readln()

        when {
            answer.equals("сообщение", ignoreCase = true) -> addNewMessage(chat)
            answer.equals("комментарий", ignoreCase = true) -> addNewThreadMessage(chat)
        }
    } while (answer.equals("сообщение", ignoreCase = true) || answer.equals("комментарий", ignoreCase = true))
}

fun addNewMessage(chat: Chat) {

    val usedIdForMessage = getUser(chat)

    println("Введите текст сообщения: ")
    val message = chat.addMessage(text = readln(), userId = usedIdForMessage)
}

fun addNewThreadMessage(chat: Chat) {

    chat.printMessages()

    println("Введите ID сообщения, к которому хотите добавить комментарий:")
    var inputForMessageId = readln().toInt()

    while (!chat.messages.any { it.messageId == inputForMessageId }) {
        println("Ошибка. Повторите ввод.")
        inputForMessageId = readln().toInt()
    }

    val usedIdForThreadMessage = getUser(chat)

    println("Введите текст комментария: ")
    val threadMessage = chat.addThreadMessage(text = readln(), userId = usedIdForThreadMessage)

    val parentMessage = chat.messages.find { it.messageId == inputForMessageId }
    parentMessage?.childMessages?.add(threadMessage)
}

fun getUser(chat: Chat): Int {

    println("Введите имя пользователя: ")
    var userName = readln()
    var userId: Int? = null
    while (userId == null) {
        val user = chat.users.find { it.name == userName }
        if (user != null) {
            userId = user.userId
        } else {
            println("Пользователь не найден. Повторите попытку.")
            userName = readln()
        }
    }
    return userId
}

class Chat(
    val users: List<ChatUser> = listOf(ChatUser("Антон", 1), ChatUser("Иван", 2)),
    val messages: MutableList<Message> = mutableListOf(),
    private val threadMessages: MutableList<ThreadMessage> = mutableListOf(),
) {

    companion object {
        var messageId: Int = 0
        var threadMessageId: Int = 0
    }

    fun addMessage(text: String, userId: Int): Message {
        val newMessageId = messageId++
        val newMessage = Message(text, userId, newMessageId)
        messages.add(newMessage)
        return newMessage
    }

    fun addThreadMessage(text: String, userId: Int): ThreadMessage {
        val newTreadMessageId = threadMessageId++
        val newTreadMessage = ThreadMessage(text, userId, newTreadMessageId)
        threadMessages.add(newTreadMessage)
        return newTreadMessage
    }

    fun printMessages() {
        println(messages.joinToString("\n") { message ->
            "${users.first { users -> users.userId == message.userId }.name}: ${message.text}.\n " +
                    "ID сообщения ${message.messageId}."
        })
    }

    fun printChat() {

        val groupedChildMessages = messages.flatMap { message ->
            message.childMessages.map { childMessage ->
                message.messageId to childMessage
            }
        }.groupBy({ it.first }, { it.second })

        messages.forEach { message ->
            val userName = users.first { it.userId == message.userId }.name
            println("$userName: ${message.text}")

            groupedChildMessages[message.messageId]?.forEach { childMessage ->
                val childUserName = users.first { it.userId == childMessage.userId }.name
                println("\t$childUserName: ${childMessage.text}\n")
            }
        }
    }
}

class ChatUser(
    val name: String,
    val userId: Int,
)

class Message(
    var text: String = "",
    var userId: Int,
    var messageId: Int,

    ) {

    val childMessages = mutableListOf<ThreadMessage>()
}

class ThreadMessage(
    var text: String = "",
    var userId: Int,
    var threadMessageId: Int,
)
