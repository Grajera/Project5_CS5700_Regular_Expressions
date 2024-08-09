package PasswordStateMachineStates

import regular_expressions.BadState
import regular_expressions.State

/**
 * Represents the second step in the password validation process.
 */
object PasswordCapitalLetterFoundState : State {
    override fun next(char: String): State = when {
        char == " " -> BadState() // Invalid if space is encountered
        char in "!@#$%^&*()" -> PasswordValidated // Move to valid state if a special character is found
        else -> PasswordCapitalLetterFoundState // Stay in this state
    }
}
