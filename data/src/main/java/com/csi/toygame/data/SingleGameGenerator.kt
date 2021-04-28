package com.csi.toygame.data

import com.csi.toygame.domain.model.Game
import com.csi.toygame.domain.model.GameGenerator
import java.util.*

class SingleGameGenerator(private val positiveRandomNumberGenerator: PositiveRandomNumberGenerator) : GameGenerator {
    override fun generate(): Game {
        return Game(UUID.randomUUID().toString(), positiveRandomNumberGenerator.generate())
    }
}