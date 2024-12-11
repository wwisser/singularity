import kotlin.random.Random
import kotlin.math.roundToInt

class Casino(val moniker: String) {
    val games = listOf(
        WheelOfMisfortune(),
        GuessTheIdiot(),
        LoseYourMonkeys(),
        CrashGame()
    )

    fun grandEntrance() {
        println("""
        ___   ___   ___   ___   ___   ___   ___   ___   ___ 
        |   \ /   | |   \ /   | |   \ /   | |   \ /   | |   \
        | |\   /| | | |\   /| | | |\   /| | | |\   /| | | |\ 
        | | \ / | | | | \ / | | | | \ / | | | | \ / | | | | \
        | |  V  | | | |  V  | | | |  V  | | | |  V  | | | |  
        | |     | | | |     | | | |     | | | |     | | | |  
        |_|     |_| |_|     |_| |_|     |_| |_|     |_| |_|
        Welcome to $moniker, where sophistication meets stupidity!
        """.trimIndent())
    }

    fun paradeOfGames() {
        println("Choose your poison, brave soul: ${games.joinToString(", ") { "**${it.name}**" }}")
    }

    fun partakeInGame(selection: String): String {
        return games.find { it.name.equals(selection, ignoreCase = true) }?.play()
            ?: "Invalid choice. Your IQ is now visible to satellites."
    }
}

abstract class Game(val name: String) {
    abstract fun play(): String
}

class WheelOfMisfortune : Game("Spin the Wheel (of Misfortune)") {
    override fun play(): String {
        val outcomes = listOf("It broke!", "It spun... into another dimension!", "You owe us for the wheel now.")
        return "You spun the wheel... ${outcomes.random()}"
    }
}

class GuessTheIdiot : Game("Guess the Idiot") {
    override fun play(): String {
        val idiocyLevel = Random.nextInt(1, 11)
        return "You guessed yourself, achieving an idiocy level of $idiocyLevel. Here's your digital dunce cap!"
    }
}

class LoseYourMonkeys : Game("Lose Your Monkeys") {
    override fun play(): String {
        val monkeysLost = Random.nextInt(0, 1000000)
        return "You've lost $monkeysLost monkeys. They've formed a new society without you."
    }
}

class CrashGame : Game("CRASH") {
    override fun play(): String {
        var multiplier = 1.0
        var crash = false
        var iterations = 0
        while (!crash && iterations < 50) {
            if (Random.nextDouble() < 0.9 - (iterations * 0.005)) {
                multiplier += 0.1
            } else {
                crash = true
            }
            iterations++
        }
        val explosion = if (crash) "💥" else "😱"
        return "Game $explosion at x${"%.2f".format(multiplier)}. In mock mode, you just witnessed a spectacular crash!"
    }
}

fun main() {
    val casino = Casino("GamesClub.me")

    casino.grandEntrance()
    casino.paradeOfGames()

    val selection = readLine()?.lowercase() ?: ""
    println(casino.partakeInGame(selection))

    val balance = (Random.nextDouble() - 1.0).roundToInt() // Always negative, but with a twist
    println("Your balance: **$balance XMR**. Because, why not?")
    println("Thanks for playing at GamesClub.me, come back when you've evolved!")
}