package com.csi.toygame.feature.single.state

import com.csi.toygame.base.StateFactory
import com.csi.toygame.feature.single.state.SinglePlayStateFactory.Param

interface SinglePlayStateFactory : StateFactory<Param> {

    sealed class Param {
        object GameStart : Param()
        object GameEnd : Param()
        data class TooLowNumber(val guessNumber: Int) : Param()
        data class TooHighNumber(val guessNumber: Int) : Param()
    }
}