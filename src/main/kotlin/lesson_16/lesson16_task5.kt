package org.example.lesson_16


fun main() {

    val player = Player("Вася", MAX_HEALTH, 15)
    val enemy = Player("Петя", MAX_HEALTH, 16)



    while (player.health > DEATH && enemy.health > DEATH) {

        val playerHit = player.makeHit()
        enemy.getDamage(playerHit)
        Thread.sleep(SLEEP)

        val enemyHit = enemy.makeHit()
        player.getDamage(enemyHit)
        Thread.sleep(SLEEP)

        if (player.health == DEATH || enemy.health == DEATH) break

        player.getPot()
        Thread.sleep(SLEEP)
        enemy.getPot()
        Thread.sleep(SLEEP)
    }
}

class Player(
    private val name: String,
    var health: Short,
    private var maxHitDamage: Short,
    private var isAbleToGetPot: Boolean = true,
) {

    fun makeHit(): Short {
        val hitDamage: Short = (MISS..maxHitDamage).random().toShort()

        if (hitDamage == MISS) println("$name промахнулся.")
        else println("$name нанес $hitDamage урона.")

        return hitDamage
    }

    fun getDamage(damage: Short): Short {

        if (damage >= health) die()
        else health = (health - damage).toShort()

        println("У $name осталось $health здоровья.")
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

    fun getPot() {
        if (isAbleToGetPot) {

            val isLucky = Math.random() > 0.4
            if (!isLucky) restoreHealth()
        }
    }

    private fun die() {

        health = DEATH
        maxHitDamage = DEATH
        isAbleToGetPot = false
        println("$name погиб.")
    }
}

private const val MAX_HEALTH: Short = 100
private const val DEATH: Short = 0
private const val POT = 15
private const val MISS: Short = 0
private const val SLEEP = 200L
