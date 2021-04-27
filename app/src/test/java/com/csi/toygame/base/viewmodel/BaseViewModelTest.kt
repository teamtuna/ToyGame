package com.csi.toygame.base.viewmodel

import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.viewbinding.ViewBinding
import com.csi.toygame.getOrAwaitValue
import org.hamcrest.core.Is.`is`
import org.junit.After
import org.junit.Assert.assertNull
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class BaseViewModelTest {

    private lateinit var viewModel: TestViewModel

    @Mock
    private lateinit var viewBinding: ViewBinding

    @Mock
    private lateinit var mockContext: Context

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        viewModel = TestViewModel()
    }

    @After
    fun tearDown() {
    }

    @Test
    fun getStateSet() {
        val stateSet = testStateFactory.create("TEST")
        viewModel.testState(stateSet)
        viewModel.stateSet.getOrAwaitValue().handle(viewBinding)
        assertThat(
            viewModel.stateSet.getOrAwaitValue().first { it is StringState },
            `is`(StringState("TEST"))
        )
    }

    @Test
    fun getCommand() {
        val stub = StubCommand("TEST")
        viewModel.testCommand(stub)

        assertThat(
            viewModel.command.getOrAwaitValue().getContentIfNotHandled(),
            `is`(stub)
        )

        viewModel.command.getOrAwaitValue().getContentIfNotHandled()?.execute(mockContext)

        assertNull(viewModel.command.getOrAwaitValue().getContentIfNotHandled())

    }
}