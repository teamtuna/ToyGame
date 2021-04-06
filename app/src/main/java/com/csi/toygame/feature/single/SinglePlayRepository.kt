package com.csi.toygame.feature.single

interface SinglePlayRepository {
    fun guess(i: Int) : Guess
}