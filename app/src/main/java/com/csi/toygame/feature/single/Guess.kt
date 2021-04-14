package com.csi.toygame.feature.single

sealed class Guess {
    object CantGuess : Guess()
    object TooLow : Guess()
    object TooHigh : Guess()
    data class Correct(val triedCount : Int) : Guess()
}
