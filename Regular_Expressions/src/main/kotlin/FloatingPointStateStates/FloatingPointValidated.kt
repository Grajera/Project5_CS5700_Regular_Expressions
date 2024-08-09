package FloatingPointStateStates

import regular_expressions.BadState
import regular_expressions.State
import regular_expressions.Validation

/**
 * Represents a valid state for floating point validation.
 */
object FloatingPointValidated : State, Validation {
    override fun tokenize(token: String): State = when {
        token in "0123456789" -> FloatingPointValidated // Continue to accept digits
        else -> BadState() // Any other character is invalid
    }
}
