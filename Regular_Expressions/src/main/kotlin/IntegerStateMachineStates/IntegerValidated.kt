package IntegerStateMachineStates

import regular_expressions.BadState
import regular_expressions.State
import regular_expressions.Validation

/**
 * Represents the valid state in the integer validation process.
 */
object IntegerValidated : State, Validation {
    override fun tokenize(token: String): State = when {
        token in "0123456789" -> IntegerValidated // Continue accepting digits
        else -> BadState() // Invalid input
    }
}
