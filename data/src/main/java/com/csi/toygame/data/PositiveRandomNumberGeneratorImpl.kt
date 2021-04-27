package com.csi.toygame.data

import kotlin.random.Random

class PositiveRandomNumberGeneratorImpl : PositiveRandomNumberGenerator {
    override fun generate(): Int {
        return Random.nextInt(1, 101)
    }
}