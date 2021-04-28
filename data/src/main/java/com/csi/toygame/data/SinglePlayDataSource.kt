package com.csi.toygame.data

import com.csi.toygame.domain.model.Game
import com.csi.toygame.domain.model.GameGenerator
import com.csi.toygame.domain.model.GameRule
import com.csi.toygame.domain.model.Guess

class SinglePlayDataSource(
        private val generator: GameGenerator,
        private val gameCache: GameCache,
        private val gameRule: GameRule
) : PlayDataSource {
    override fun generateGame(): Game {
        return generator.generate().also {
            gameCache[it.id] = it
        }
    }

    override fun guessScore(id: String, guess: Int): Guess {
        val game = gameCache[id] ?: return Guess.CantGuess

        if (!gameRule.isCanGuessNumber(game.score, guess)) {
            return Guess.CantGuess
        }
        return game.guess(guess)
    }

    override fun getTryOnCount(id: String): Int {
        return gameCache[id]?.tryOnCount ?: 0
    }
}