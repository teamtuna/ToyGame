package com.csi.toygame.data

import com.csi.toygame.domain.model.Game
import com.csi.toygame.domain.model.GameRule
import com.csi.toygame.domain.model.Guess

class SinglePlayDataSource(
    private val generator: PositiveRandomNumberGenerator,
    private val gameRule: GameRule
) : PlayDataSource {
    private lateinit var currentGame: Game

    override fun generateScore() {
        currentGame = Game(generator.generate())
    }

    override fun guessScore(guess: Int): Guess {
        if (!::currentGame.isInitialized || !gameRule.isCanGuessNumber(currentGame.score, guess)) {
            return Guess.CantGuess
        }

        return currentGame.guess(guess)
    }

    override fun getTryOnCount(): Int {
        return currentGame.tryOnCount
    }


}