package com.csi.toygame.base

import androidx.viewbinding.ViewBinding

interface State {
    fun handle(binding: ViewBinding)
}
