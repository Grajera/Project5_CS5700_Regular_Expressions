package FloatingPointStateStates

import regular_expressions.BadState
import regular_expressions.State

/**
 * Represents the initial state in the floating point validation process.
 */
object FloatingPointStartState : State {
    override fun tokenize(token: String): State = when {
        token == "0" -> FloatingPointAfterZeroStartState // '0' followed by a period is valid
        token == "." -> FloatingPointAfterPeriodState // Period can start the float
        token in "123456789" -> FloatingPointNonZeroDigitState // Valid float can start with a non-zero digit
        else -> BadState() // Invalid input
    }
}
