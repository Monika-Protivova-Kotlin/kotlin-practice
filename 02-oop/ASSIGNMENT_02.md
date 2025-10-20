# Lesson 02: Object-Oriented Combat System

Refactor the procedural combat system from Lesson 01 into an object-oriented design using classes, enums, and singleton objects.

---

## Requirements

### 1. CharacterClass Enum

```kotlin
enum class CharacterClass {
    WARRIOR,
    SORCERER
}
```

### 2. Character Class

Create a `Character` class (can be `data class`) with:

**Properties:**
- `name: String` - character's name
- `health: Int` (var) - current health (mutable)
- `attack: Int` - base attack power
- `characterClass: CharacterClass` - character type

**Methods:**
- `attack(target: Character): Unit` - attack another character
- `receiveDamage(damage: Int): Unit` - process incoming damage, update health
- `isAlive(): Boolean` - check if health > 0 (use single-expression function)
- `getDamage(attack: Int): Int` (private) - calculate damage from attack power

### 3. MatchOutcome Enum

```kotlin
enum class MatchOutcome {
    CHALLENGER_WON,
    OPPONENT_WON,
    DRAW
}
```

### 4. MatchResult Data Class

```kotlin
data class MatchResult(
    val challenger: Character,
    val opponent: Character,
    val matchOutcome: MatchOutcome
)
```

**Purpose:** Store complete match information for post-match analysis and statistics.

### 5. Match Singleton Object

Create a singleton `object Match` with:

**Public Method:**
- `runMatch(rounds: Int, challenger: Character, opponent: Character): MatchResult`
  - Runs the complete match
  - Returns `MatchResult` with both characters and outcome

**Private Method:**
- `round(challenger: Character, opponent: Character): Unit`
  - Executes one round of combat
  - Challenger attacks first; opponent attacks back if alive

### 6. Update Main Function

Create `Character` instances and run matches through the `Match` object:

```kotlin
fun main() {
    val result = Match.runMatch(
        rounds = 10,
        challenger = Character("Thorin", 120, 25, CharacterClass.WARRIOR),
        opponent = Character("Gandor", 100, 30, CharacterClass.SORCERER)
    )

    // Access: result.matchOutcome, result.challenger, result.opponent
}
```

---

## Expected Output Example

```
ROUND 1:
Thorin attacks Gandor for 20 damage
Gandor received 20 and has 60 health remaining.
Gandor attacks Thorin for 25 damage
Thorin received 25 and has 75 health remaining.

ROUND 2:
Thorin attacks Gandor for 20 damage
Gandor received 20 and has 40 health remaining.
...

ROUND 4:
Thorin attacks Gandor for 20 damage
Gandor received 20 and has 0 health remaining.
Gandor has been defeated! Thorin wins!
```

---

## Key Concepts

- **Classes:** Grouping properties and methods
- **Object state:** Mutable data (`health`) within instances
- **Object declarations:** Singletons with `object` keyword
- **Enums:** Type-safe constants (`CharacterClass`, `MatchOutcome`)
- **Data classes:** Automatic `equals()`, `hashCode()`, `toString()`, `copy()`
- **Instance methods:** Operating on object state vs top-level functions
- **Single-expression functions:** Concise syntax (e.g., `fun isAlive() = health > 0`)
- **Access modifiers:** `private` for internal helpers

---

## Common Pitfalls

- ❌ Creating `Match` as a class instead of a singleton `object`
- ❌ Not updating `health` in the `receiveDamage()` method
- ❌ Returning the wrong outcome from `runMatch()`
- ❌ Not using `MatchResult` to return match information
