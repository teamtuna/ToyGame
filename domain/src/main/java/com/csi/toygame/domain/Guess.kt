package com.csi.toygame.domain

sealed class Guess {
    object CantGuess : Guess()
    object TooLow : Guess()
    object TooHigh : Guess()
    data class Correct(val triedCount : Int) : Guess()
}
