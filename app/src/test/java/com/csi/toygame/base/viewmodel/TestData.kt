package com.csi.toygame.base.viewmodel

import android.content.Context
import androidx.viewbinding.ViewBinding
import com.csi.toygame.base.Command
import com.csi.toygame.base.State
import com.csi.toygame.base.StateFactory
import com.csi.toygame.base.StateSet

data class StubCommand(val title: String) : Command {
    override fun execute(context: Context) {
        println(title)
    }

}


val testStateFactory: StateFactory<String> = object : StateFactory<String> {
    private val stateSet = StateSet()
    override fun create(value: String): StateSet {
        return stateSet.apply {
            add(StringState(value))
        }
    }


}

data class StringState(val title: String) : State {
    override fun handle(binding: ViewBinding) {
        println(title)
    }
}

