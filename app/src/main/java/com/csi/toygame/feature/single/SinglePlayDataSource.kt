package com.csi.toygame.feature.single

import kotlin.random.Random

class SinglePlayDataSource : PlayDataSource {
    private var score: Int = 0

    private var tryOnCount: Int = 0

    override fun generateScore() {
        score = Random.nextInt(1, 101)
    }

    override fun guessScore(guess: Int) {
        if (score != guess) {
            tryOnCount++
        }
    }

    override fun getTryOnCount(): Int {
        return tryOnCount
    }


}