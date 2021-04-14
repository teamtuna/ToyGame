package com.csi.toygame.feature.single

class SinglePlayRepositoryImpl(private val singlePlayDataSource: SinglePlayDataSource) :
    SinglePlayRepository {
    override fun guess(i: Int): Guess {
        return singlePlayDataSource.guessScore(i)
    }

    override fun gameStart() {
        singlePlayDataSource.generateScore()
    }
}