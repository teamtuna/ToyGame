package com.csi.toygame.base

import androidx.viewbinding.ViewBinding

class StateSet(
    private val set: MutableSet<State> = mutableSetOf()
) : State, MutableSet<State> by set {

    override fun add(state: State): Boolean {
        return set.filterNot {
            (it is SingleState && it.state.javaClass.isInstance(it)) ||
                state.javaClass.isInstance(it)
        }
            .let { set.apply { clear() }.addAll(it + setOf(state)) }
    }

    override fun handle(binding: ViewBinding) {
        set.filter { it !is SingleState || !it.hasBeenHandled }
            .forEach { it.handle(binding) }
    }
}
