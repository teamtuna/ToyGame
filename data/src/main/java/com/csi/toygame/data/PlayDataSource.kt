package com.csi.toygame.data

import com.csi.toygame.domain.model.Guess

interface PlayDataSource {
    fun generateScore()

    fun guessScore(guess: Int) : Guess

    fun getTryOnCount() : Int
}