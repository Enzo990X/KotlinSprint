package org.example.lesson_16


fun main() {

    val player = Player("Вася", MAX_HEALTH, 15)
    val enemy = Player("Петя", MAX_HEALTH, 16)



    while (player.health > DEATH && enemy.health > DEATH) {

        enemy.getDamage(player.dealDamage())
        Thread.sleep(SLEEP)
        player.getDamage(enemy.dealDamage())
        Thread.sleep(SLEEP)

        if (player.health == DEATH || enemy.health == DEATH) break

        player.getPot(isAbleToGetPot = player.isAbleToGetPot)
        Thread.sleep(SLEEP)
        enemy.getPot(isAbleToGetPot = enemy.isAbleToGetPot)
        Thread.sleep(SLEEP)
    }
}

class Player(
    private val name: String,
    var health: Short,
    var maxHitDamage: Short,
    var isAbleToGetPot: Boolean = true,
) {

    fun dealDamage(): Short {
        val hitDamage: Short = (MISS..maxHitDamage).random().toShort()
        health = (health - hitDamage).toShort()

        if (hitDamage == MISS) println("$name промахнулся.")
        else println("$name нанес $hitDamage урона.")

        return hitDamage
        }

    fun getDamage(damage: Short): Short {
        health = (health - damage).toShort()
        die()
        return health
    }

    private fun restoreHealth(): Short {

        val neededHealth = MAX_HEALTH - health

        health = if (neededHealth > POT) {
            (health + POT).toShort()
        } else {
            MAX_HEALTH
        }

        println("$name восстановил здоровье.")

        return health
    }

    fun getPot(isAbleToGetPot: Boolean) {
        if (isAbleToGetPot) {

            val isLucky = Math.random() > 0.5
            if (!isLucky) restoreHealth()
        }
    }

    private fun die() {

        if (health <= DEATH) {
            health = DEATH
            maxHitDamage = DEATH
            isAbleToGetPot = false
            println("$name погиб.")
        }
    }
}

private const val MAX_HEALTH: Short = 100
private const val DEATH: Short = 0
private const val POT = 15
private const val MISS: Short = 0
private const val SLEEP = 200L
