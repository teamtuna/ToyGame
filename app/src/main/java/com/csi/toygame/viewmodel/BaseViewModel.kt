package com.csi.toygame.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.csi.toygame.Command
import com.csi.toygame.Event
import com.csi.toygame.StateSet

open class BaseViewModel : ViewModel() {

    private val _stateSet = MediatorLiveData<StateSet>()
    val stateSet: LiveData<StateSet>
        get() = _stateSet

    protected  val _command = MediatorLiveData<Event<Command>>()
    val command: LiveData<Event<Command>>
        get() = _command

    protected fun sendCommand(command : Command){
        _command.value = Event(command)
    }

    protected fun sendState(stateSet : StateSet) {
        _stateSet.value = stateSet
    }
}