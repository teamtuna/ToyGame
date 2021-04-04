package com.csi.toygame.viewmodel

import com.csi.toygame.Command
import com.csi.toygame.StateSet

class TestViewModel : BaseViewModel() {

    fun testCommand(command: Command) {
        sendCommand(command)
    }

    fun testState(state: StateSet) {
        sendState(state)
    }
}