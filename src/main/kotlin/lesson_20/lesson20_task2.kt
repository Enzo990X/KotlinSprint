package org.example.lesson_20

fun main() {
    val player = Player("Player 1", 50, 100)

    val restoredHealth: () -> Short = {
        val neededHealth = player.maxHealth - player.currentHealth

        if (neededHealth > POT) {
            (player.currentHealth + POT).toShort()
        } else {
            player.maxHealth
        }
    }

    player.currentHealth = restoredHealth()
    println(player.currentHealth)
}


class Player(val name: String, var currentHealth: Short, val maxHealth: Short)

private const val POT = 15
