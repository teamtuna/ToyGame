package com.csi.toygame.base

import android.content.Context

interface Command {
    fun execute(context: Context)
}
