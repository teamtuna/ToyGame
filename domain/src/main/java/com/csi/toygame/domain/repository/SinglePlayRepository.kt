package com.csi.toygame.domain.repository

import com.csi.toygame.domain.model.Guess

interface SinglePlayRepository {
    fun guess(i: Int) : Guess
    fun gameStart()
}