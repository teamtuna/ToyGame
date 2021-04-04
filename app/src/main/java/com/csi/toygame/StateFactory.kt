package com.csi.toygame

interface StateFactory<T> {

    fun create(value: T): StateSet
}