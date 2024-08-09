package BinaryStateMachineStates

import regular_expressions.BadState
import regular_expressions.State

/**
 * Represents the initial state in the binary validation process.
 */
object BinaryStartingState : State {
    override fun next(char: String): State = when {
        char == "1" -> BinaryValid // Valid if starting with a '1'
        else -> BadState() // Invalid input
    }
}
