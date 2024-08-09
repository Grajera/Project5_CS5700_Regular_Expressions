package FloatingPointStateStates

import regular_expressions.BadState
import regular_expressions.State

/**
 * Represents the first step in the floating point validation process.
 */
object FloatingPointAfterZeroStartState : State {
    override fun tokenize(token: String): State = when {
        token in "." -> FloatingPointAfterPeriodState // Valid if digits follow the period
        else -> BadState() // Any other character is invalid
    }
}