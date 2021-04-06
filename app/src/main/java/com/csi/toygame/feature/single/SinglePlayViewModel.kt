package com.csi.toygame.feature.single

import com.csi.toygame.base.viewmodel.BaseViewModel
import com.csi.toygame.feature.single.state.SinglePlayStateFactory
import com.csi.toygame.feature.single.state.SinglePlayStateFactory.Param.*

class SinglePlayViewModel(
    private val singlePlayStateFactory: SinglePlayStateFactory,
    private val singlePlayRepository: SinglePlayRepository
) :
    BaseViewModel() {

    fun gameStart() {
        sendState(singlePlayStateFactory.create(GameStart))
    }

    fun guess(i: Int) {
        when (singlePlayRepository.guess(i)) {
            Guess.Correct -> sendState(singlePlayStateFactory.create(GameEnd))
            Guess.TooHigh -> sendState(singlePlayStateFactory.create(TooHighNumber(i)))
            Guess.TooLow -> sendState(singlePlayStateFactory.create(TooLowNumber(i)))
        }

    }
}