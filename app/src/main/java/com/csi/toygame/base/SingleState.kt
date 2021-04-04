package com.csi.toygame.base

import androidx.viewbinding.ViewBinding

class SingleState(val state: State) : State by state {

    var hasBeenHandled = false
        private set

    override fun handle(binding: ViewBinding) {
        if (!hasBeenHandled) {
            hasBeenHandled = true
            state.handle(binding)
        }
    }
}

fun State.toSingle(): SingleState = SingleState(this)
