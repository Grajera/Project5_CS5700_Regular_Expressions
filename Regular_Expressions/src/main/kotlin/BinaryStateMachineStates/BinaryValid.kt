package BinaryStateMachineStates

import regular_expressions.BadState
import regular_expressions.State

/**
 * Represents a valid state for binary validation.
 */
object BinaryValid : State {
    override fun next(char: String): State = when {
        char == "1" -> BinaryValid // Continue accepting '1's
        char == "0" -> BinaryValid // Accept '0's
        else -> BadState() // Any other character is invalid
    }
}
