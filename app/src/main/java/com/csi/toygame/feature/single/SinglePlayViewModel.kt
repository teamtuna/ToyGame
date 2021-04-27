package com.csi.toygame.feature.single

import com.csi.toygame.base.viewmodel.BaseViewModel
import com.csi.toygame.domain.model.Guess
import com.csi.toygame.domain.repository.SinglePlayRepository
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
        when (val guess = singlePlayRepository.guess(i)) {
            is Guess.Correct -> {
                sendState(singlePlayStateFactory.create(GameEnd(guess.triedCount)))
            }
            is Guess.TooHigh -> sendState(singlePlayStateFactory.create(TooHighNumber(i)))
            is Guess.TooLow -> sendState(singlePlayStateFactory.create(TooLowNumber(i)))
            Guess.CantGuess -> TODO()
        }
    }
}