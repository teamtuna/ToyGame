package com.csi.toygame.feature.single

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers
import org.junit.Test

class SingleGameRuleTest {

    private val gameRule: GameRule = SingleGameRule()

    @Test
    fun 게임룰_1부터_100까지_안에_숫자가_속해있지않으면_게임룰에_어긋나는것으로_판단된다() {
        assertThat(gameRule.isCanGuessNumber(101, 1), Matchers.equalTo(false))
        assertThat(gameRule.isCanGuessNumber(-100, 1), Matchers.equalTo(false))
    }

    @Test
    fun 게임룰_1부터_100까지_안에_숫자가_속해있으면_게임룰이_맞다는걸_판단한다() {
        assertThat(gameRule.isCanGuessNumber(99, 1), Matchers.equalTo(true))
        assertThat(gameRule.isCanGuessNumber(1, 1), Matchers.equalTo(true))
    }
}