package com.csi.toygame

import android.content.Context

class CommandList(private vararg val commands: Command) : Command {
    override fun execute(context: Context) {
        commands.forEach {
            it.execute(context)
        }
    }
}
