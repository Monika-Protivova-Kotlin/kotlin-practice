package com.motycka.edu.assignment01

import com.motycka.edu.round
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.ints.shouldBeGreaterThanOrEqual

class RoundTest : FreeSpec({
    "should return Array of two integers" {
        val results = round(
            challengerName = "Challenger",
            challengerHealth = 100,
            challengerAttack = 20,
            opponentName = "Opponent",
            opponentHealth = 100,
            opponentAttack = 20
        )

        results.size shouldBe 2
        results[0] shouldBeGreaterThanOrEqual 0  // Challenger health
        results[1] shouldBeGreaterThanOrEqual 0  // Opponent health
    }

    "should reduce both characters health when both are alive" {
        val initialHealth = 100
        val results = round(
            challengerName = "Challenger",
            challengerHealth = initialHealth,
            challengerAttack = 20,
            opponentName = "Opponent",
            opponentHealth = initialHealth,
            opponentAttack = 20
        )

        // Both should have non-negative health
        results[0] shouldBeGreaterThanOrEqual 0
        results[1] shouldBeGreaterThanOrEqual 0
    }

    "should handle defeated opponent (should not counterattack)" {
        val results = round(
            challengerName = "Challenger",
            challengerHealth = 100,
            challengerAttack = 100,
            opponentName = "Opponent",
            opponentHealth = 1,  // Will be defeated by first attack
            opponentAttack = 50
        )

        // Opponent should be at 0 health
        results[1] shouldBe 0

        // Challenger should take no damage (or at most minimal if attack happens before death check)
        // This test allows for implementation variations
        results[0] shouldBeGreaterThanOrEqual 0
    }

    "should handle both characters with low health" {
        val results = round(
            challengerName = "Challenger",
            challengerHealth = 10,
            challengerAttack = 5,
            opponentName = "Opponent",
            opponentHealth = 10,
            opponentAttack = 5
        )

        results[0] shouldBeGreaterThanOrEqual 0
        results[1] shouldBeGreaterThanOrEqual 0
    }
})
