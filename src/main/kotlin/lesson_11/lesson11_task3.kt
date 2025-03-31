package org.example.lesson_11

import java.io.File
import java.security.SecureRandom


fun main() {

    val room = Room(0, "Чердак", File("/path/to/image.jpg"))
    val user = User3(0, "Иван Иванов", "", File("/path/to/image.jpg"))

    room.addParticipant(user)
    room.showUserName(user)
    println(user.getUserStatus(room))

    user.isSpeaking = true
    println(user.getUserStatus(room))

    user.isSpeaking = false
    user.isMicOn = true
    println(user.getUserStatus(room))

    user.isMicOn = false
    room.isUserMuted = true
    println(user.getUserStatus(room))
}

private class Room(
    val roomId: Int,
    val roomName: String,
    val roomImage: File = File("/path/to/image.jpg"),
) {

    private val userSessions = mutableMapOf<Int, MutableList<UserSession>>()

    fun generateSessionId(): String {
        val random = SecureRandom()
        val bytes = ByteArray(BYTES)
        random.nextBytes(bytes)
        return bytes.joinToString("") { "%02x".format(it) }
    }

    fun addParticipant(user: User3) {
        val newSessionId = generateSessionId()
        val userSessionsList = userSessions.getOrPut(user.userId) { mutableListOf() }
        userSessionsList.add(UserSession(user.userId, newSessionId))
        user.sessionId = newSessionId
        println("${user.userName} вошёл в комнату $roomName.")
    }

    fun showUserName(user: User3) {
        println("Имя пользователя: " + user.userName)
    }

    var isUserMuted = false
}

private class User3(
    val userId: Int,
    val userName: String,
    var sessionId: String,
    var userImage: File = File("/path/to/image.jpg"),
    var isSpeaking: Boolean = false,
    var isMicOn: Boolean = false,
) {
    val userStatus: List<Boolean>
        get() = listOf(isSpeaking, isMicOn, false)

    fun getUserStatus(room: Room): String {
        val userStatus = listOf(isSpeaking, isMicOn, room.isUserMuted)
        return when {
            userStatus[0] -> "Говорит"
            userStatus[1] -> "Микрофон выключен"
            userStatus[2] -> "Пользователь заглушен"
            else -> "Слушает"
        }
    }
}

class UserSession(val userId: Int, val sessionId: String)

private const val BYTES = 16