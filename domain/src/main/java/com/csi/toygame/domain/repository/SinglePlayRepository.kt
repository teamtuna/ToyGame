package com.csi.toygame.domain.repository

import com.csi.toygame.domain.model.Game
import com.csi.toygame.domain.model.Guess

interface SinglePlayRepository {
    fun guess(id : String, i: Int) : Guess
    fun gameStart() : Game
}