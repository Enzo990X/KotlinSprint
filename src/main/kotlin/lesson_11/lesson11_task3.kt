package org.example.lesson_11

import java.io.File

fun main() {

    val room = Room(0, "Чердак", File("/path/to/image.jpg"), mutableListOf())
    val user = User3(0, "Иван Иванов", File("/path/to/image.jpg"), "Слушает")

    room.addParticipant(user.userId, user.userName, user.userImage, user.userStatus)

    room.showUserName(user)

    println(user.userStatus)

    showUserStatus(user, room)
    println(user.userStatus)

}

private class Room(
    val roomId: Int,
    val roomName: String,
    val roomImage: File = File("/path/to/image.jpg"),
    val roomParticipants: MutableList<Int>,
) {

    fun addParticipant(userId: Int, userName: String, userImage: File, userStatus: String) {
        roomParticipants.add(userId)
        println("$userName вошёл в комнату $roomName")
    }

    fun showUserName(user: User3) {
        println("Имя пользователя: " + user.userName)
    }

    fun muteParticipant(): Boolean {

        var isUserMuted = false
        //код проверки кнопки заглушения в комнате для конкретного пользователя

        if (isUserMuted) {
            return true
        } else {
            return false
        }
    }
}

private class User3(
    val userId: Int,
    val userName: String,
    var userImage: File = File("/path/to/image.jpg"),
    var userStatus: String,
)

private fun showUserStatus(user: User3, room: Room): String {
    val isSpeaking = checkForSpeech()
    val isMicOn = checkMic()
    val isUserMuted = room.muteParticipant()

    user.userStatus = when {
        isSpeaking -> "Говорит"
        isMicOn -> "Микрофон выключен"
        isUserMuted -> "Заглушен"
        else -> "Слушает"
    }

    return user.userStatus
}

private fun checkForSpeech(): Boolean {

    var isSpeaking = true
    //код проверки наличия речи в комнате для конкретного пользователя

    if (isSpeaking) {
        return true
    } else {
        return false
    }
}

private fun checkMic(): Boolean {

    var isMicOn = false
    //код проверки наличия микрофона в комнате для конкретного пользователя

    if (isMicOn) {
        return true
    } else {
        return false
    }
}