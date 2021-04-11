package com.csi.toygame.feature.single

interface PlayDataSource {
    fun generateScore()

    fun guessScore(guess: Int)

    fun getTryOnCount() : Int
}