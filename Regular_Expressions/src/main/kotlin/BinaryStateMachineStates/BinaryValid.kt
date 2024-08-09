package BinaryStateMachineStates

import regular_expressions.BadState
import regular_expressions.State
import regular_expressions.Validation

/**
 * Represents a valid state for binary validation.
 */
class BinaryValid : State, Validation {
    override fun tokenize(token: String): State = when {
        token == "1" -> BinaryValid() // Continue accepting '1's
        token == "0" -> BinaryZeroState() // Accept '0's
        else -> BadState() // Any other character is invalid
    }
}
