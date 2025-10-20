package com.motycka.edu.assignment01

import com.motycka.edu.match
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class MatchTest : FreeSpec({
    "should complete without errors" {
        // This test verifies that match() can be called and completes
        // We don't test return value since match() returns Unit
        match(
            rounds = 3,
            challengerName = "Challenger",
            challengerHealth = 100,
            challengerAttack = 20,
            opponentName = "Opponent",
            opponentHealth = 100,
            opponentAttack = 20
        )

        // If we get here without exception, test passes
        true shouldBe true
    }

    "should handle single round" {
        match(
            rounds = 1,
            challengerName = "Challenger",
            challengerHealth = 100,
            challengerAttack = 20,
            opponentName = "Opponent",
            opponentHealth = 100,
            opponentAttack = 20
        )

        true shouldBe true
    }
})
