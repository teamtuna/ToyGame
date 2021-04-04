package com.csi.toygame.viewmodel

import android.content.Context
import androidx.viewbinding.ViewBinding
import com.csi.toygame.Command
import com.csi.toygame.State
import com.csi.toygame.StateFactory
import com.csi.toygame.StateSet

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

