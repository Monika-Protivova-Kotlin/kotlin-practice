package com.motycka.edu.assignment02

import com.motycka.edu.MatchOutcome
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.collections.shouldContain

/**
 * Tests for MatchOutcome enum
 *
 * Tests verify:
 * - Enum has all expected values
 * - All match outcome states are represented
 */
class MatchOutcomeTest : FreeSpec({

    "should have three possible outcomes" {
        val outcomes = MatchOutcome.entries
        outcomes.size shouldBe 3
        outcomes shouldContain MatchOutcome.CHALLENGER_WON
        outcomes shouldContain MatchOutcome.OPPONENT_WON
        outcomes shouldContain MatchOutcome.DRAW
    }
})
