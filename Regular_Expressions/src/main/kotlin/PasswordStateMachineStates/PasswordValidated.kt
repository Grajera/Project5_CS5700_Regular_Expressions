package PasswordStateMachineStates

import regular_expressions.BadState
import regular_expressions.State
import regular_expressions.Validation

/**
 * Represents a valid state for password validation.
 */
object PasswordValidated : State, Validation {
    override fun next(char: String): State = when {
        char == " " -> BadState() // Invalid if space is encountered
        else -> PasswordValidated // Stay in the valid state
    }
}
