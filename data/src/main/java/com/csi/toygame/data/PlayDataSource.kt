package com.csi.toygame.data

import com.csi.toygame.domain.model.Game
import com.csi.toygame.domain.model.Guess

interface PlayDataSource {
    fun generateGame() : Game

    fun guessScore(id : String, guess: Int) : Guess

    fun getTryOnCount(id : String) : Int
}