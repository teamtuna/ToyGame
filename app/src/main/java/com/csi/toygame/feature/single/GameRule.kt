package com.csi.toygame.feature.single

interface GameRule {
    fun isCanGuessNumber(score : Int, guess: Int): Boolean

}
