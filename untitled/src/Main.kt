fun main() {
    println("Welcome to the Retard's Casino, where losing is the only winning move!")

    val games = listOf("Spin the Wheel (of Misfortune)", "Guess the Idiot", "Lose Your Monkeys")
    println("Choose your game, ya dummy: ${games.joinToString(", ")}")

    when(readLine()?.lowercase()) {
        "spin the wheel (of misfortune)" -> {
            println("You spun the wheel... and it broke. You pay for repairs!")
        }
        "guess the idiot" -> {
            println("You guessed yourself. Congrats, you win a participation trophy!")
        }
        "lose your monkeys" -> {
            println("You lost all your imaginary monkeys. Guess they were never good at hide and seek.")
        }
        else -> {
            println("You can't even choose right. Classic retard move.")
        }
    }

    println("Your balance: -1 XMR. Because, why not?")

    println("Thanks for playing, come back when you find your brain!")
}