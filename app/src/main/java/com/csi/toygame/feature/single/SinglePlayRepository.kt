package com.csi.toygame.feature.single

import com.csi.toygame.domain.Guess

interface SinglePlayRepository {
    fun guess(i: Int) : Guess
    fun gameStart()
}