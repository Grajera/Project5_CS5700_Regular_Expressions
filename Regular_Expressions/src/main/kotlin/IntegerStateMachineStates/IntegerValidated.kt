package IntegerStateMachineStates

import regular_expressions.BadState
import regular_expressions.State

/**
 * Represents the valid state in the integer validation process.
 */
object IntegerValidated : State {
    override fun next(char: String): State = when {
        char in "0123456789" -> IntegerValidated // Continue accepting digits
        else -> BadState() // Invalid input
    }
}
