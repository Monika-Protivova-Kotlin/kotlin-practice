package com.motycka.edu

/**
 * Assignment 01: Kotlin Essentials - Procedural Programming
 *
 * This assignment demonstrates basic Kotlin concepts using procedural programming:
 * - Variables and data types
 * - Functions with parameters and return values
 * - Conditional expressions (when)
 * - Loops (for)
 * - Arrays
 */

fun main() {
    val rounds = 10
    val challengerName = "Thorin"
    val challengerHealth = 100
    val challengerAttack = 20
    val opponentName = "Gandor"
    val opponentHealth = 80
    val opponentAttack = 25

    match(
        rounds = rounds,
        challengerName = challengerName,
        challengerHealth = challengerHealth,
        challengerAttack = challengerAttack,
        opponentName = opponentName,
        opponentHealth = opponentHealth,
        opponentAttack = opponentAttack
    )

}

fun attack(
    attackerName: String,
    attackerPower: Int,
    targetName: String,
    targetHealth: Int
): Int {
    val damage = getDamage(attack = attackerPower)
    println("$attackerName attacks $targetName for $damage damage")
    return receiveAttack(name = targetName, health = targetHealth, damage = damage)
}

fun receiveAttack(
    name: String,
    health: Int,
    damage: Int
): Int {
    val remainingHealth = when {
        health - damage >= 0 -> health - damage
        else -> 0
    }

    println("$name received $damage and has $remainingHealth health remaining.")

    return remainingHealth
}

fun getDamage(attack: Int): Int {
    // In a real game, this could include randomness, critical hits, etc.
    return attack / arrayOf(1, 2, 4).random()
}

fun round(
    challengerName: String,
    challengerHealth: Int,
    challengerAttack: Int,
    opponentName: String,
    opponentHealth: Int,
    opponentAttack: Int
): Array<Int> {

    val opponentHealth = attack(challengerName, challengerAttack, opponentName, opponentHealth)

    val challengerHealth = if (opponentHealth > 0) {
        attack(opponentName, opponentAttack, challengerName, challengerHealth)
    } else challengerHealth

    return arrayOf(challengerHealth, opponentHealth)
}

fun match(
    rounds: Int,
    challengerName: String,
    challengerHealth: Int,
    challengerAttack: Int,
    opponentName: String,
    opponentHealth: Int,
    opponentAttack: Int
) {
    println("\nMATCH: $challengerName vs $opponentName\n")
    var challengerHealthRemaining = challengerHealth
    var opponentHealthRemaining = opponentHealth

    for (round in 1..rounds) {
        println("\nROUND $round:")
        val results = round(
            challengerName = challengerName,
            challengerHealth = challengerHealthRemaining,
            challengerAttack = challengerAttack,
            opponentName = opponentName,
            opponentHealth = opponentHealthRemaining,
            opponentAttack = opponentAttack
        )

        challengerHealthRemaining = results[0]
        opponentHealthRemaining = results[1]

        when {
            challengerHealthRemaining <= 0 -> {
                println("$challengerName has been defeated! $opponentName wins!")
                break
            }
            opponentHealthRemaining <= 0 -> {
                println("$opponentName has been defeated! $challengerName wins!")
                break
            }
            else -> continue
        }
    }

    println("The match ended in a draw after $rounds rounds!")
}
