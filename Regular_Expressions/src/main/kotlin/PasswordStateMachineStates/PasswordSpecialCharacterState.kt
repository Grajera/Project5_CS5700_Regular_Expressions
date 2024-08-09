package PasswordStateMachineStates

import regular_expressions.BadState
import regular_expressions.State

/**
 * Represents the third step in the password validation process.
 */
object PasswordSpecialCharacterState : State {
    override fun next(char: String): State = when {
        char == " " -> BadState() // Invalid if space is encountered
        else -> PasswordSpecialCharacterState // Stay in this state
    }
}
