package com.motycka.edu.assignment01

import com.motycka.edu.getDamage
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.ints.shouldBeGreaterThan
import io.kotest.matchers.ints.shouldBeGreaterThanOrEqual
import io.kotest.matchers.ints.shouldBeLessThanOrEqual

class GetDamageTest : FreeSpec({
    "should return damage within reasonable bounds" {
        val attackPower = 100
        val damage = getDamage(attack = attackPower)

        damage shouldBeGreaterThan 0
        damage shouldBeLessThanOrEqual attackPower
    }

    "should handle low attack values" {
        val damage = getDamage(attack = 1)
        damage shouldBeGreaterThanOrEqual 0
    }

    "should handle zero attack" {
        val damage = getDamage(attack = 0)
        damage shouldBe 0
    }
})
