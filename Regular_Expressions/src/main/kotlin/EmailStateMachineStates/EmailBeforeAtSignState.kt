package EmailStateMachineStates

import regular_expressions.BadState
import regular_expressions.State

/**
 * Represents the first step in the email validation process.
 */
object EmailBeforeAtSignState : State {
    override fun next(char: String): State = when {
        char == " " -> BadState() // Invalid if space is encountered
        char == "@" -> EmailAfterAtSignState // Move to step 2 if '@' is found
        else -> EmailBeforeAtSignState // Stay in this state
    }
}
