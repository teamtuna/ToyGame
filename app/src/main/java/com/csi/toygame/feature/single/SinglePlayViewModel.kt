package com.csi.toygame.feature.single

import com.csi.toygame.base.viewmodel.BaseViewModel
import com.csi.toygame.feature.single.state.SinglePlayStateFactory
import com.csi.toygame.feature.single.state.SinglePlayStateFactory.Param.GameStart

class SinglePlayViewModel(private val singlePlayStateFactory: SinglePlayStateFactory) :
    BaseViewModel() {

    fun gameStart() {
        sendState(singlePlayStateFactory.create(GameStart))
    }
}