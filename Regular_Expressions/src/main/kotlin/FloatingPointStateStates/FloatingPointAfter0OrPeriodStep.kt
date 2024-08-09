package FloatingPointStateStates

import regular_expressions.BadState
import regular_expressions.State

/**
 * Represents the second step in the floating point validation process.
 */
object FloatingPointAfter0OrPeriodStep : State {
    override fun next(char: String): State = when {
        char in "0123456789" -> FloatingPointValidated // Valid if digits follow the period
        else -> BadState() // Any other character is invalid
    }
}