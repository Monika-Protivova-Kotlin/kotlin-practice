package com.motycka.edu.assignment01

import com.motycka.edu.attack
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.ints.shouldBeGreaterThanOrEqual
import io.kotest.matchers.ints.shouldBeLessThanOrEqual

class AttackTest : FreeSpec({
    "should return updated target health" {
        val targetHealth = 100
        val updatedHealth = attack(
            attackerName = "Attacker",
            attackerPower = 20,
            targetName = "Target",
            targetHealth = targetHealth
        )

        updatedHealth shouldBeLessThanOrEqual targetHealth
        updatedHealth shouldBeGreaterThanOrEqual 0
    }

    "should reduce target health by some amount" {
        val targetHealth = 100
        val attackPower = 50
        val updatedHealth = attack(
            attackerName = "Attacker",
            attackerPower = attackPower,
            targetName = "Target",
            targetHealth = targetHealth
        )

        // Updated health should be non-negative
        updatedHealth shouldBeGreaterThanOrEqual 0
    }

    "should return non-negative health" {
        val targetHealth = 10
        val attackPower = 100
        val updatedHealth = attack(
            attackerName = "Attacker",
            attackerPower = attackPower,
            targetName = "Target",
            targetHealth = targetHealth
        )

        updatedHealth shouldBeGreaterThanOrEqual 0
    }

    "handles target with zero health" {
        val targetHealth = 0
        val updatedHealth = attack(
            attackerName = "Attacker",
            attackerPower = 20,
            targetName = "Target",
            targetHealth = targetHealth
        )

        updatedHealth shouldBe 0
    }
})
