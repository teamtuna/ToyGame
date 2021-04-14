package com.csi.toygame.feature.single

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.csi.toygame.feature.single.state.*
import com.csi.toygame.getOrAwaitValue
import com.nhaarman.mockitokotlin2.whenever
import junit.framework.Assert.assertEquals
import org.junit.*
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class SinglePlayViewModelTest {

    private lateinit var viewModel: SinglePlayViewModel

    @Mock
    private lateinit var singlePlayRepository: SinglePlayRepository

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        viewModel = SinglePlayViewModel(SinglePlayStateFactoryImpl(), singlePlayRepository)
    }

    @After
    fun tearDown() {
    }

    @Test
    fun 싱글모드가_처음_시작하게_되면_안내메세지와함께_입력값을_받도록_함() {
        //GIVEN
        viewModel.gameStart()

        //THEN
        Assert.assertTrue(
            viewModel.stateSet
                .getOrAwaitValue()
                .filterIsInstance(GameStartState::class.java)
                .isNotEmpty()
        )

    }

    @Test
    fun 싱글모드에서_잘못된_숫자가_맞추려는_숫자보다_높으면_높다는_안내를_제공하고_다시_입력을_받도록_함() {
        //GIVEN
        viewModel.gameStart()

        //WHEN
        whenever(singlePlayRepository.guess(100)).thenReturn(Guess.TooHigh)
        viewModel.guess(100)

        //THEN
        Assert.assertTrue(
            viewModel.stateSet
                .getOrAwaitValue()
                .filterIsInstance(TooHighNumberState::class.java)
                .isNotEmpty()
        )
    }

    @Test
    fun 싱글모드에서_잘못된_숫자가_맞추려는_숫자보다_낮으면_낮다는_안내를_제공하고_다시_입력을_받도록_함() {
        //GIVEN
        viewModel.gameStart()

        //WHEN
        whenever(singlePlayRepository.guess(1)).thenReturn(Guess.TooLow)

        viewModel.guess(1)

        //THEN
        Assert.assertTrue(
            viewModel.stateSet
                .getOrAwaitValue()
                .filterIsInstance(TooLowNumberState::class.java)
                .isNotEmpty()
        )
    }

    @Test
    fun 싱글모드에서_숫자를_맞추면_시도한_숫자를_표기하고_정답을_맞췄음을_알려야_함() {
        //GIVEN
        viewModel.gameStart()

        //WHEN
        whenever(singlePlayRepository.guess(1)).thenReturn(Guess.TooLow)
        whenever(singlePlayRepository.guess(100)).thenReturn(Guess.TooHigh)
        whenever(singlePlayRepository.guess(30)).thenReturn(Guess.TooLow)
        whenever(singlePlayRepository.guess(40)).thenReturn(Guess.Correct(4))
        viewModel.guess(1)
        viewModel.guess(100)
        viewModel.guess(30)
        viewModel.guess(40)

        //THEN
        assertEquals(
            4,
            viewModel.stateSet
                .getOrAwaitValue()
                .filterIsInstance(GameEndState::class.java)
                .first().triedCount
        )
    }

    @Test
    fun 싱글모드에서_숫자를_맞추고_다시게임을_시작하면_게임이_다시_리셋되서_처음으로_돌아온것으로_인지() {
        //GIVEN
        viewModel.gameStart()

        //WHEN
        whenever(singlePlayRepository.guess(1)).thenReturn(Guess.TooLow)
        whenever(singlePlayRepository.guess(100)).thenReturn(Guess.TooHigh)
        whenever(singlePlayRepository.guess(30)).thenReturn(Guess.TooLow)
        whenever(singlePlayRepository.guess(50)).thenReturn(Guess.Correct(4))
        viewModel.guess(1)
        viewModel.guess(100)
        viewModel.guess(30)
        viewModel.guess(50)


        viewModel.gameStart()
        whenever(singlePlayRepository.guess(50)).thenReturn(Guess.Correct(1))
        viewModel.guess(50)

        //THEN
        assertEquals(
            1,
            viewModel.stateSet
                .getOrAwaitValue()
                .filterIsInstance(GameEndState::class.java)
                .first().triedCount
        )
    }
}