package FloatingPointStateStates

import regular_expressions.BadState
import regular_expressions.State

/**
 * Represents the initial state in the floating point validation process.
 */
object FloatingPointStartState : State {
    override fun next(char: String): State = when {
        char == "0" -> FloatingPointAfter0OrPeriodStep // '0' followed by a period is valid
        char == "." -> FloatingPointAfter0OrPeriodStep // Period can start the float
        char in "123456789" -> FloatingPointNonZeroDigitState // Valid float can start with a non-zero digit
        else -> BadState() // Invalid input
    }
}
