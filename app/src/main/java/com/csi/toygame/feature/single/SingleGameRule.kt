package com.csi.toygame.feature.single

class SingleGameRule : GameRule {
    override fun isCanGuessNumber(score: Int, guess: Int): Boolean {
        return score in 1..100
    }
}