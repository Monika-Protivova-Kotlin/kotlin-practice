package com.motycka.edu.assignment02

import com.motycka.edu.Character
import com.motycka.edu.CharacterClass
import com.motycka.edu.Match
import com.motycka.edu.MatchOutcome
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue

/**
 * Tests for BasicMatch singleton object
 *
 * Tests verify:
 * - Match outcome: CHALLENGER_WON
 * - Match outcome: OPPONENT_WON
 * - Match outcome: DRAW
 * - Match stops when one character dies
 */
class MatchTest : FreeSpec({

    "should return challenger won when opponent defeated" {
        val strongWarrior = Character(
            name = "Strong",
            health = 200,
            attack = 50,
            characterClass = CharacterClass.WARRIOR
        )
        val weakSorcerer = Character(
            name = "Weak",
            health = 50,
            attack = 5,
            characterClass = CharacterClass.SORCERER
        )

        val result = Match.runMatch(
            rounds = 10,
            challenger = strongWarrior,
            opponent = weakSorcerer
        )

        result.matchOutcome shouldBe MatchOutcome.CHALLENGER_WON
        strongWarrior.isAlive().shouldBeTrue()
        weakSorcerer.isAlive().shouldBeFalse()
    }

    "should return opponent won when challenger defeated" {
        val weakWarrior = Character(
            name = "Weak",
            health = 50,
            attack = 5,
            characterClass = CharacterClass.WARRIOR
        )
        val strongSorcerer = Character(
            name = "Strong",
            health = 200,
            attack = 50,
            characterClass = CharacterClass.SORCERER
        )

        val result = Match.runMatch(
            rounds = 10,
            challenger = weakWarrior,
            opponent = strongSorcerer
        )

        result.matchOutcome shouldBe MatchOutcome.OPPONENT_WON
        weakWarrior.isAlive().shouldBeFalse()
        strongSorcerer.isAlive().shouldBeTrue()
    }

    "should return draw when both survive max rounds" {
        val tankWarrior = Character(
            name = "Tank",
            health = 1000,
            attack = 1,
            characterClass = CharacterClass.WARRIOR
        )
        val tankSorcerer = Character(
            name = "Tank2",
            health = 1000,
            attack = 1,
            characterClass = CharacterClass.SORCERER
        )

        val result = Match.runMatch(
            rounds = 5,
            challenger = tankWarrior,
            opponent = tankSorcerer
        )

        result.matchOutcome shouldBe MatchOutcome.DRAW
        tankWarrior.isAlive().shouldBeTrue()
        tankSorcerer.isAlive().shouldBeTrue()
    }

    "should stop when one character dies" {
        val warrior = Character(
            name = "TestWarrior",
            health = 100,
            attack = 20,
            characterClass = CharacterClass.WARRIOR
        )
        val sorcerer = Character(
            name = "TestSorcerer",
            health = 80,
            attack = 25,
            characterClass = CharacterClass.SORCERER
        )

        val result = Match.runMatch(
            rounds = 100,
            challenger = warrior,
            opponent = sorcerer
        )

        // Match should end before 100 rounds
        (result.matchOutcome == MatchOutcome.CHALLENGER_WON ||
         result.matchOutcome == MatchOutcome.OPPONENT_WON).shouldBeTrue()

        // One should be dead, one alive
        (warrior.isAlive() xor sorcerer.isAlive()).shouldBeTrue()
    }
})
