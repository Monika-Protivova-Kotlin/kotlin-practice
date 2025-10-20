# Kotlin Practice Assignments

This repository contains **8 progressive assignments** that teach Kotlin fundamentals, 
object-oriented programming, collections, testing, concurrency, and software architecture.

---

## Prerequisites

- **Java 23** installed
- **Git** for cloning the repository
- **IntelliJ IDEA** (recommended) or any Kotlin-compatible IDE

---

## Getting Started

### 1. Clone the Repository

```bash
git clone <repository-url>
cd kotlin-practice-source
```

### 2. Build the Project

```bash
./gradlew build
```

### 3. Verify Setup

```bash
./gradlew test
```

All tests should run (some may fail until you complete assignments).

---

## Assignment Structure

Assignments will be organized across 5 modules:

| Assignment | Module | Files to Modify |
|------------|--------|-----------------|
| [01 - Procedural Combat](01-basic/ASSIGNMENT_01.md) | `01-basic/` | `Assignment01.kt` |
| [02 - OOP Basics](02-oop/ASSIGNMENT_02.md) | `02-oop/` | `Assignment02.kt`, `Character.kt`, `CharacterClass.kt`, `Match.kt`, `MatchOutcome.kt`, `MatchResult.kt` |
| [03 - Collections](02-oop/ASSIGNMENT_03.md) | `02-oop/` | `Assignment03.kt`, `FantasySpaceGame.kt`, `Leaderboard.kt`, `LeaderboardEntry.kt` |
| [04 - File I/O](02-oop/ASSIGNMENT_04.md) | `02-oop/` | `Assignment04.kt` |
| [05 - OOP Principles](03-advanced-oop/ASSIGNMENT_05.md) | `03-advanced-oop/` | `Assignment05.kt`, `Character.kt`, `Defender.kt`, `Healer.kt`, `Recoverable.kt`, `Sorcerer.kt`, `Warrior.kt` |
| [06 - Testing](03-advanced-oop/ASSIGNMENT_06.md) | `03-advanced-oop/` | `MatchTest.kt`, `SorcererTest.kt`, `WarriorTest.kt` |
| [07 - Concurrency](04-concurrency/ASSIGNMENT_07.md) | `04-concurrency/` | `Assignment07.kt`, `CoffeeShop.kt`, `MenuItem.kt`, `Order.kt`, `OrderGenerator.kt` |
| [08 - SOLID & DI](05-app/ASSIGNMENT_08.md) | `05-app/` | `Assignment08.kt`, `CharacterService.kt`, `CharacterServiceImpl.kt`, `FantasySpaceGame.kt`, `LeaderboardService.kt`, `LeaderboardServiceImpl.kt`, `MatchService.kt`, `MatchServiceImpl.kt` |

Each assignment has detailed requirements in its markdown file (click the assignment name to view).

I will upload the assignment before each lesson.

---

## How to complete Assignments

1. Read the assignment document carefully. Follow the instructions and implement the required classes/functions in the specified files.
2. When you are done, you can run the auto-grading tests to verify your implementation.
3. **Commit and push your changes to your forked repository.** This will also trigger automated grading via GitHub Actions.

---

## Auto-Grading System

### How It Works

Each assignment module contains comprehensive auto-grading tests:

- Tests verify your implementation correctness
- Tests check adherence to requirements (e.g., using interfaces, proper encapsulation)
- Tests are organized by assignment: `com.motycka.edu.assignment01` through `assignment08`

### Running Grading Tests

**Test a specific assignment:**
```bash
# Assignment 01
./gradlew :01-basic:test

# Assignments 02-04
./gradlew :02-oop:test

# Assignments 05-06
./gradlew :03-advanced-oop:test

# Assignment 07
./gradlew :04-concurrency:test

# Assignment 08
./gradlew :05-app:test
```

**Test all assignments:**
```bash
./gradlew test
```

**View detailed results:**

After running tests, open the HTML report for the specific module:
```
<module-name>/build/reports/tests/test/index.html
```

For example:
```
01-basic/build/reports/tests/test/index.html
02-oop/build/reports/tests/test/index.html
```

This shows:
- Number of tests passed/failed
- Specific error messages for failures
- Test execution times

### Understanding Test Results

✅ **Green (Passed)**: Your implementation is correct
❌ **Red (Failed)**: Check the error message for what's wrong
⚠️ **Yellow (Skipped)**: Test was not run (usually dependencies failed)

---

## Running Your Code

### Run a Specific Assignment

```bash
# Assignment 01
./gradlew :01-basic:run

# Assignment 08
./gradlew :05-app:run
```

### Run Module Tests (Your Own Tests)

For Assignment 06, you'll write your own tests. Run them with:

```bash
./gradlew :03-advanced-oop:test
```

---

## Common Commands

```bash
# Build everything
./gradlew build

# Clean build artifacts
./gradlew clean

# Run all tests (all assignments)
./gradlew test

# Test a specific module
./gradlew :01-basic:test
./gradlew :02-oop:test
./gradlew :03-advanced-oop:test
./gradlew :04-concurrency:test
./gradlew :05-app:test

# Run an assignment
./gradlew :01-basic:run
./gradlew :05-app:run
```

---

## Tips for Success

- ✅ **Read the assignment document carefully** before coding
- ✅ **Run auto-grading tests frequently** to catch errors early
- ✅ **Check the "Common Pitfalls"** section in each assignment
- ✅ **Review test error messages** - they tell you exactly what's wrong
- ✅ **Build incrementally** - implement one function/class at a time and test

---

Good luck! 🚀
