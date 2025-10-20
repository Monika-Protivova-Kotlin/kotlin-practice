package com.motycka.edu

data class Character(
    val name: String,
    // other character properties ...
    val characterClass: CharacterClass
) {
    fun attack(target: Character) {
        // Simple attack logic for demonstration purposes
    }

    // receiveDamage

    // isAlive
}
