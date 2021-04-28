package com.csi.toygame.data.feature.single

import com.csi.toygame.data.SinglePlayDataSource
import com.csi.toygame.data.repository.SinglePlayRepositoryImpl
import com.csi.toygame.domain.model.Game
import com.csi.toygame.domain.model.Guess
import com.csi.toygame.domain.repository.SinglePlayRepository
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class SinglePlayRepositryTest {
    private lateinit var singlePlayRepository: SinglePlayRepository

    @Mock
    private lateinit var singlePlayDataSource: SinglePlayDataSource

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        singlePlayRepository = SinglePlayRepositoryImpl(singlePlayDataSource)
    }

    @After
    fun tearDown() {
    }

    @Test
    fun gameStart시_가상의_정답_Score_가_Generate_된다() {
        singlePlayRepository.gameStart()


        verify(singlePlayDataSource).generateGame()
    }

    @Test
    fun gameStart후_guess시_Guess_결과값을_반환한다() {
        whenever(singlePlayDataSource.generateGame()).thenReturn(Game("1", 3))
        val game = singlePlayRepository.gameStart()
        whenever(singlePlayDataSource.guessScore(game.id, 50)).thenReturn(Guess.TooLow)

        val actual = singlePlayRepository.guess(game.id, 50)

        assertThat(actual, Matchers.equalTo(Guess.TooLow))
    }
}