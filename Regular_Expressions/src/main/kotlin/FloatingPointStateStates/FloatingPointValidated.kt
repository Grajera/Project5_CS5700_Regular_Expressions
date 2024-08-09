package FloatingPointStateStates

import regular_expressions.BadState
import regular_expressions.State

/**
 * Represents a valid state for floating point validation.
 */
object FloatingPointValidated : State {
    override fun next(char: String): State = when {
        char in "0123456789" -> FloatingPointValidated // Continue to accept digits
        else -> BadState() // Any other character is invalid
    }
}
