package com.csi.toygame.data.repository

import com.csi.toygame.data.SinglePlayDataSource
import com.csi.toygame.domain.model.Game
import com.csi.toygame.domain.model.Guess
import com.csi.toygame.domain.repository.SinglePlayRepository

class SinglePlayRepositoryImpl(private val singlePlayDataSource: SinglePlayDataSource) : SinglePlayRepository {

    override fun guess(id: String, i: Int): Guess {
        return singlePlayDataSource.guessScore(id, i)
    }

    override fun gameStart(): Game {
        return singlePlayDataSource.generateGame()
    }
}