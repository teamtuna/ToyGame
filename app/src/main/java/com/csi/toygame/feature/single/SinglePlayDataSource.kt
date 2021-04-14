package com.csi.toygame.feature.single

class SinglePlayDataSource(private val generator: PositiveRandomNumberGenerator) : PlayDataSource {
    private var score: Int = 0

    private var tryOnCount: Int = 0

    override fun generateScore() {
        score = generator.generate()
    }

    override fun guessScore(guess: Int): Guess {
        return when (compareValues(score, guess)) {
            1 -> Guess.TooLow
            0 -> Guess.Correct
            else -> Guess.TooHigh
        }.also {
            checkTryOnCount(it)
        }
    }

    override fun getTryOnCount(): Int {
        return tryOnCount
    }

    private fun checkTryOnCount(guessResult: Guess) {
        when (guessResult) {
            Guess.Correct -> tryOnCount = 0
            else -> tryOnCount++
        }
    }


}