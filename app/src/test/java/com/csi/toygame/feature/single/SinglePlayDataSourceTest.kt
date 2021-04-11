package com.csi.toygame.feature.single

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers
import org.hamcrest.Matchers.equalTo
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.MockitoAnnotations

class SinglePlayDataSourceTest {

    private lateinit var singlePlayDataSource: PlayDataSource

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        singlePlayDataSource = SinglePlayDataSource()
    }

    @After
    fun tearDown() {
    }

    @Test
    fun 정답이_실패시_tryOnCount가_하나_증가한다() {
        // GIVEN
        singlePlayDataSource.generateScore()
        val beforeTryOnCount = singlePlayDataSource.getTryOnCount()

        // WHEN
        singlePlayDataSource.guessScore(90)

        // THEN
        val actual = singlePlayDataSource.getTryOnCount()

        assertThat(actual, equalTo(beforeTryOnCount + 1))
    }

    @Test
    fun 정답이_실패시_숫자가_정답보다_높아서_실패인지_낮아서_실패인지_알려주도록한다() {

    }

    @Test
    fun 정답이_성공시_tryOnCount가_0이된다() {

    }

    @Test
    fun 정답이_성공시_정답여부를_반환한다() {

    }


}