package com.csi.toygame.domain

data class Game(val score: Int) {
    private val tryNumber = mutableListOf<Int>()

    val tryOnCount: Int
        get() = tryNumber.size

    fun guess(guess: Int): Guess {
        return when (compareValues(score, guess)) {
            1 -> Guess.TooLow
            0 -> Guess.Correct(tryOnCount)
            else -> Guess.TooHigh
        }.also {
            checkTryOnCount(it, guess)
        }
    }

    private fun checkTryOnCount(result: Guess, guessNumber: Int) {
        when (result) {
            is Guess.Correct -> tryNumber.clear()
            else -> tryNumber.add(guessNumber)
        }
    }
}