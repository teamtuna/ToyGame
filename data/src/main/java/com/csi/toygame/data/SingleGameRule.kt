package com.csi.toygame.data

import com.csi.toygame.domain.model.GameRule

class SingleGameRule : GameRule {
    override fun isCanGuessNumber(score: Int, guess: Int): Boolean {
        return score in 1..100
    }
}