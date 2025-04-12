package org.example.lesson_21

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
    while (!player.isHealthy()) {
        player.currentHealth = restoredHealth()
        println("Уровень здоровья: ${player.currentHealth}")
        Thread.sleep(1000)
    }
    println("Здоровье полностью восстановлено.")
}


class Player(val name: String, var currentHealth: Short, val maxHealth: Short)

fun Player.isHealthy(): Boolean = currentHealth == maxHealth


private const val POT = 15
