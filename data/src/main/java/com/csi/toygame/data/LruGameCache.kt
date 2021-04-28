package com.csi.toygame.data

import androidx.collection.LruCache
import com.csi.toygame.domain.model.Game

class LruGameCache : GameCache {

    private val cache = LruCache<String, Game>(10)

    override operator fun get(id: String): Game? {
        return cache[id]
    }

    override fun set(id: String, game: Game) {
        cache.put(id, game)
    }
}