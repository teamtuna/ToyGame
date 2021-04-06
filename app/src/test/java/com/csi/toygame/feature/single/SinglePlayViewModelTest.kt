package com.csi.toygame.feature.single

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.csi.toygame.feature.single.state.GameStartState
import com.csi.toygame.feature.single.state.SinglePlayStateFactoryImpl
import com.csi.toygame.feature.single.state.TooHighNumberState
import com.csi.toygame.getOrAwaitValue
import org.junit.*
import org.mockito.MockitoAnnotations

class SinglePlayViewModelTest {

    private lateinit var viewModel: SinglePlayViewModel

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        viewModel = SinglePlayViewModel(SinglePlayStateFactoryImpl())
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
        viewModel.guess(1)

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

    }

    @Test
    fun 싱글모드에서_잘못된_숫자를_입력한만큼_입력한_숫자_카운트가_나와야_함() {

    }

    @Test
    fun 싱글모드에서_숫자를_맞추면_시도한_숫자를_표기하고_정답을_맞췄음을_알려야_함() {

    }
}