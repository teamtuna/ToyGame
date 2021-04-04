package com.csi.toygame.feature.single

import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.MockitoAnnotations

class SinglePlayDataSourceTest {

    private lateinit var singlePlayDataSource : SinglePlayDataSource

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

    }

    @Test
    fun 정답이_성공시_tryOnCount가_0이된다() {

    }

    @Test
    fun 정답이_성공시_정답여부를_반환한다() {

    }


}