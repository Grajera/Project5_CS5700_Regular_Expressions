package EmailStateMachineStates

import regular_expressions.BadState
import regular_expressions.State
import regular_expressions.Validation

/**
 * Represents a valid state for email validation.
 */
object EmailValidated : State, Validation {
    override fun tokenize(token: String): State = when {
        token == " " || token == "@" || token == "." -> BadState() // Invalid if space, '@', or '.' is found
        else -> EmailValidated // Stay in the valid state
    }
}
