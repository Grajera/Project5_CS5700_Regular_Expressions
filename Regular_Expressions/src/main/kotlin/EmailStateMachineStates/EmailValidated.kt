package EmailStateMachineStates

import regular_expressions.BadState
import regular_expressions.State
import regular_expressions.Validation

/**
 * Represents a valid state for email validation.
 */
object EmailValidated : State, Validation {
    override fun next(char: String): State = when {
        char == " " || char == "@" || char == "." -> BadState() // Invalid if space, '@', or '.' is found
        else -> EmailValidated // Stay in the valid state
    }
}
