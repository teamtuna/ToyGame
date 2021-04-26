package com.csi.toygame.feature.single

import com.csi.toygame.domain.Game
import com.csi.toygame.domain.Guess

interface GameRule {
    fun isCanGuessNumber(score : Int, guess: Int): Boolean
}
