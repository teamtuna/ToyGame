package com.csi.toygame.data.feature.single

import com.csi.toygame.domain.model.Guess
import com.nhaarman.mockitokotlin2.whenever
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.*
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class SinglePlayDataSourceTest {

    private lateinit var singlePlayDataSource: com.csi.toygame.data.PlayDataSource

    @Mock
    private lateinit var generator: com.csi.toygame.data.PositiveRandomNumberGenerator

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        singlePlayDataSource = com.csi.toygame.data.SinglePlayDataSource(
            generator,
            com.csi.toygame.data.SingleGameRule()
        )
    }

    @After
    fun tearDown() {
    }

    @Test
    fun 정답이_실패시_tryOnCount가_하나_증가한다() {
        // GIVEN
        whenever(generator.generate()).thenReturn(50)
        singlePlayDataSource.generateScore()
        val beforeTryOnCount = singlePlayDataSource.getTryOnCount()

        // WHEN
        singlePlayDataSource.guessScore(90)

        // THEN
        val actual = singlePlayDataSource.getTryOnCount()

        assertThat(actual, equalTo(beforeTryOnCount + 1))
    }

    @Test
    fun 정답이_실패시_숫자가_정답보다_높으면_높다는_결과를_제공한다() {
        // GIVEN
        whenever(generator.generate()).thenReturn(50)
        singlePlayDataSource.generateScore()

        // WHEN
        val guessResult = singlePlayDataSource.guessScore(90)

        // THEN
        assertThat(guessResult, equalTo(Guess.TooHigh))

    }

    @Test
    fun 정답이_실패시_숫자가_정답보다_낮으면_낮다는_결과를_제공한다() {
        // GIVEN
        whenever(generator.generate()).thenReturn(50)
        singlePlayDataSource.generateScore()

        // WHEN
        val guessResult = singlePlayDataSource.guessScore(40)

        // THEN
        assertThat(guessResult, equalTo(Guess.TooLow))

    }

    @Test
    fun 정답이_성공시_tryOnCount가_0이된다() {
        // GIVEN
        whenever(generator.generate()).thenReturn(50)
        singlePlayDataSource.generateScore()

        // WHEN
        val tryOnCount = singlePlayDataSource.getTryOnCount()

        // THEN
        assertThat(tryOnCount, equalTo(0))
    }

    @Test
    fun 정답이_성공시_정답여부를_반환한다() {
        // GIVEN
        whenever(generator.generate()).thenReturn(50)
        singlePlayDataSource.generateScore()

        // WHEN
        val actual = singlePlayDataSource.guessScore(50)

        // THEN
        assertThat(actual, instanceOf(Guess.Correct::class.java))
    }

    @Test
    fun 정답이_generate안된경우_Guess가_안되도록_한다() {
        // GIVEN

        // WHEN
        val actual = singlePlayDataSource.guessScore(50)

        // THEN
        assertThat(actual, equalTo(Guess.CantGuess))
    }

    @Test
    fun GuessCount가_시도한_횟수만큼_나와야한다() {
        // GIVEN
        whenever(generator.generate()).thenReturn(50)
        singlePlayDataSource.generateScore()
        // WHEN
        singlePlayDataSource.guessScore(10)
        singlePlayDataSource.guessScore(20)
        singlePlayDataSource.guessScore(30)
        val actual = singlePlayDataSource.guessScore(50)

        // THEN
        assertThat(actual, instanceOf(Guess.Correct::class.java))
        assertThat((actual as Guess.Correct).triedCount, equalTo(3))
    }


}