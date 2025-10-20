# Lesson 01: Character Battle System

Build a procedural turn-based combat system in Kotlin.

---

## Requirements

### 1. Main Function Variables

Create variables in `main()`:
- `rounds: Int` - number of rounds to fight
- Challenger: `name`, `health`, `attack`
- Opponent: `name`, `health`, `attack`

### 2. Combat Functions

#### `getDamage(attack: Int): Int`
Calculate damage from attack power (use any formula, e.g. `attack / arrayOf(1, 2, 4).random()`)

#### `attack(attackerName: String, attackerPower: Int, targetName: String, targetHealth: Int): Int`
- Calculate damage using `getDamage()`
- Print: `"[attackerName] attacks [targetName] for [damage] damage"`
- Apply damage using `receiveAttack()`
- Return updated health

#### `receiveAttack(name: String, health: Int, damage: Int): Int`
- Calculate remaining health (minimum 0)
- Print: `"[name] received [damage] and has [remainingHealth] health remaining."`
- Return updated health

#### `round(...): Array<Int>`
- Execute one round (both characters attack if alive)
- Challenger attacks first; if opponent survives, they attack back
- Return `[updatedChallengerHealth, updatedOpponentHealth]`

#### `match(...): Unit`
- Run multiple rounds using a loop
- Print round numbers
- Check win conditions after each round:
  - If challenger health ≤ 0: opponent wins
  - If opponent health ≤ 0: challenger wins
- If no winner after all rounds: draw

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

- Variables: `val` vs `var`
- Functions: parameters, return types
- Control flow: `when`, `if-else`, `for` loops
- String templates: `"$variable"`
- Arrays: `arrayOf()` and indexing
- Range iteration: `for (i in 1..n)`

---

## Common Pitfalls

- ❌ Forgetting to check if health goes below 0 (use `if` or `when` to set minimum to 0)
- ❌ Not checking if opponent is alive before counter-attacking
- ❌ Hardcoding values instead of using parameters
- ❌ Missing break condition in match loop when someone dies
