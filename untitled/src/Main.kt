import kotlin.random.Random

class Casino(val name: String) {
    val games = listOf(
        WheelOfMisfortune(),
        GuessTheIdiot(),
        LoseYourMonkeys(),
        CrashGame()
    )

    fun welcomeMessage() {
        println("Welcome to $name, where sophistication meets stupidity!")
    }

    fun displayGames() {
        println("Choose your game, dear patron: ${games.joinToString { it.name }}")
    }

    fun playGame(choice: String): String {
        return games.find { it.name.equals(choice, ignoreCase = true) }?.play() ?: "Invalid choice. Your IQ is showing."
    }
}

abstract class Game(val name: String) {
    abstract fun play(): String
}

class WheelOfMisfortune : Game("Spin the Wheel (of Misfortune)") {
    override fun play(): String {
        return "You spun the wheel... and it broke. You pay for repairs!"
    }
}

class GuessTheIdiot : Game("Guess the Idiot") {
    override fun play(): String {
        return "You guessed yourself. Congrats, you win a participation trophy!"
    }
}

class LoseYourMonkeys : Game("Lose Your Monkeys") {
    override fun play(): String {
        return "You lost all your imaginary monkeys. Guess they were never good at hide and seek."
    }
}

class CrashGame : Game("CRASH") {
    override fun play(): String {
        var multiplier = 1.0
        while (Random.nextDouble() < 0.9) {
            multiplier += 0.1
        }
        return "Game crashed at x${"%.2f".format(multiplier)}. In mock mode, you neither win nor lose, just crash!"
    }
}

fun main() {
    val casino = Casino("GamesClub.me")

    casino.welcomeMessage()
    casino.displayGames()

    val choice = readLine()?.lowercase() ?: ""
    println(casino.playGame(choice))

    println("Your balance: -1 XMR. Because, why not?")
    println("Thanks for playing at GamesClub.me, come back when you find your brain!")
}