package FloatingPointStateStates

import regular_expressions.BadState
import regular_expressions.State

/**
 * Represents the first step in the floating point validation process.
 */
object FloatingPointNonZeroDigitState : State {
    override fun next(char: String): State = when {
        char == "." -> FloatingPointAfter0OrPeriodStep // Move to step 2 if '.' is found
        char in "0123456789" -> FloatingPointNonZeroDigitState // Continue accepting digits
        else -> BadState() // Invalid input
    }
}
