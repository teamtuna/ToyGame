package com.csi.toygame

import androidx.viewbinding.ViewBinding

interface State {
    fun handle(binding: ViewBinding)
}
