package IntegerStateMachineStates

import regular_expressions.BadState
import regular_expressions.State

/**
 * Represents the initial state in the integer validation process.
 */
object InitialIntegerState : State {
    override fun tokenize(token: String): State = when {
        token in "123456789" -> IntegerValidated // Valid if starting with a non-zero digit
        else -> BadState() // Invalid input
    }
}
