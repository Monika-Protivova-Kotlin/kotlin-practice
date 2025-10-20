package com.motycka.edu.assignment02

import com.motycka.edu.Character
import com.motycka.edu.CharacterClass
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.booleans.shouldBeFalse
import io.kotest.matchers.booleans.shouldBeTrue
import io.kotest.matchers.ints.shouldBeGreaterThanOrEqual
import io.kotest.matchers.ints.shouldBeLessThan

/**
 * Tests for Character class
 *
 * Tests verify:
 * - Initial properties (name, health, attack)
 * - isAlive() method
 * - receiveDamage() method
 * - attack() method
 */
class CharacterTest : FreeSpec({

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

    "should have correct initial properties" {
        warrior.name shouldBe "TestWarrior"
        warrior.health shouldBe 100
        warrior.attack shouldBe 20
        warrior.characterClass shouldBe CharacterClass.WARRIOR

        sorcerer.name shouldBe "TestSorcerer"
        sorcerer.health shouldBe 80
        sorcerer.attack shouldBe 25
        sorcerer.characterClass shouldBe CharacterClass.SORCERER
    }

    "should be alive when health is positive" {
        warrior.isAlive().shouldBeTrue()
    }

    "should not be alive when health is zero" {
        val deadWarrior = warrior.copy(health = 0)
        deadWarrior.isAlive().shouldBeFalse()
    }

    "receiveDamage should reduce health" {
        val testWarrior = warrior.copy()
        val initialHealth = testWarrior.health
        testWarrior.receiveDamage(30)

        testWarrior.health shouldBe initialHealth - 30
        testWarrior.isAlive().shouldBeTrue()
    }

    "receiveDamage should not go below zero" {
        val testWarrior = warrior.copy()
        testWarrior.receiveDamage(150)

        testWarrior.health shouldBe 0
        testWarrior.isAlive().shouldBeFalse()
    }

    "attack should damage opponent" {
        val testWarrior = warrior.copy()
        val testSorcerer = sorcerer.copy()
        val initialHealth = testSorcerer.health

        testWarrior.attack(testSorcerer)

        testSorcerer.health shouldBeLessThan initialHealth
        testSorcerer.health shouldBeGreaterThanOrEqual 0
    }

    "should have characterClass property" {
        warrior.characterClass shouldBe CharacterClass.WARRIOR
        sorcerer.characterClass shouldBe CharacterClass.SORCERER
    }
})
