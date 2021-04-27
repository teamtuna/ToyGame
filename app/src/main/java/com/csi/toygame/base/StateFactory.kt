package com.csi.toygame.base

interface StateFactory<T> {

    fun create(value: T): StateSet
}