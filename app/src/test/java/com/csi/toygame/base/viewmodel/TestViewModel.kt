package com.csi.toygame.base.viewmodel

import com.csi.toygame.base.Command
import com.csi.toygame.base.StateSet
import com.csi.toygame.base.viewmodel.BaseViewModel

class TestViewModel : BaseViewModel() {

    fun testCommand(command: Command) {
        sendCommand(command)
    }

    fun testState(state: StateSet) {
        sendState(state)
    }
}