package com.csi.toygame

import android.content.Context

interface Command {
    fun execute(context: Context)
}
