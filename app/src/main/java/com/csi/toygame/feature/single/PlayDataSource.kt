package com.csi.toygame.feature.single

import com.csi.toygame.domain.Guess

interface PlayDataSource {
    fun generateScore()

    fun guessScore(guess: Int) : Guess

    fun getTryOnCount() : Int
}