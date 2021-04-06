package com.csi.toygame.feature.single.state

import com.csi.toygame.base.StateSet
import com.csi.toygame.feature.single.state.SinglePlayStateFactory.Param
import com.csi.toygame.feature.single.state.SinglePlayStateFactory.Param.*

class SinglePlayStateFactoryImpl : SinglePlayStateFactory {

    private val stateSet = StateSet()
    override fun create(value: Param): StateSet {
        val state = when (value) {
            is GameEnd -> GameEndState(triedCount = value.triedCount)
            is GameStart -> GameStartState()
            is TooHighNumber -> TooHighNumberState()
            is TooLowNumber -> TooLowNumberState()
        }

        return stateSet.apply {
            add(state)
        }
    }
}