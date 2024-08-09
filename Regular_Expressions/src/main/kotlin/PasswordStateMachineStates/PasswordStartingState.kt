package PasswordStateMachineStates

import regular_expressions.BadState
import regular_expressions.State

/**
 * Represents the initial state in the password validation process.
 */
object PasswordStartingState : State {
    override fun next(char: String): State = when {
        char == " " -> BadState() // Invalid if space is encountered
        char in "ABCDEFGHIJKLMNOPQRSTUVWXYZ" -> PasswordCapitalLetterFoundState // Move to step 2 if a capital letter is found
        char in "!@#$%^&*()" -> PasswordSpecialCharacterState // Move to step 3 if a special character is found
        else -> PasswordStartingState // Stay in this state
    }
}
