package com.csi.toygame.data.feature.single

import com.csi.toygame.data.PositiveRandomNumberGeneratorImpl
import com.csi.toygame.data.SingleGameGenerator
import com.csi.toygame.domain.model.GameGenerator
import junit.framework.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class SingleGameGeneratorTest {

    private lateinit var gameGenerator: GameGenerator

    @Before
    fun setUp() {
        gameGenerator = SingleGameGenerator(PositiveRandomNumberGeneratorImpl())
    }

    @Test
    fun generate_임의의숫자를_정답으로_가지는_게임객체를_생성() {
        val game = gameGenerator.generate()

        assertTrue(game.score > 0)
    }
}