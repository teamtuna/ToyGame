package com.csi.toygame.domain.model

interface GameRule {
    fun isCanGuessNumber(score : Int, guess: Int): Boolean
}
