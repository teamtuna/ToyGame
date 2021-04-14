package com.csi.toygame.feature.single

import kotlin.random.Random

class PositiveRandomNumberGeneratorImpl : PositiveRandomNumberGenerator {
    override fun generate(): Int {
        return Random.nextInt(1, 101)
    }
}