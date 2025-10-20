package com.motycka.edu.assignment01

import com.motycka.edu.receiveAttack
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class ReceiveAttackTest : FreeSpec({
    "should reduce health correctly when damage is less than health" {
        val initialHealth = 100
        val damage = 30
        val remainingHealth = receiveAttack(
            name = "TestCharacter",
            health = initialHealth,
            damage = damage
        )

        remainingHealth shouldBe 70
    }

    "should prevent negative health (floors at 0)" {
        val initialHealth = 50
        val damage = 80
        val remainingHealth = receiveAttack(
            name = "TestCharacter",
            health = initialHealth,
            damage = damage
        )

        remainingHealth shouldBe 0
    }

    "should handle exact lethal damage" {
        val initialHealth = 100
        val damage = 100
        val remainingHealth = receiveAttack(
            name = "TestCharacter",
            health = initialHealth,
            damage = damage
        )

        remainingHealth shouldBe 0
    }

    "should handle zero damage" {
        val initialHealth = 100
        val damage = 0
        val remainingHealth = receiveAttack(
            name = "TestCharacter",
            health = initialHealth,
            damage = damage
        )

        remainingHealth shouldBe 100
    }

    "should handle massive overkill damage" {
        val initialHealth = 20
        val damage = 1000
        val remainingHealth = receiveAttack(
            name = "TestCharacter",
            health = initialHealth,
            damage = damage
        )

        remainingHealth shouldBe 0
    }
})
