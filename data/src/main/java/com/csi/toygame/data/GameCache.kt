package com.csi.toygame.data

import com.csi.toygame.domain.model.Game

interface GameCache {
    operator fun get(id: String): Game?
    operator fun set(id: String, game: Game)
}