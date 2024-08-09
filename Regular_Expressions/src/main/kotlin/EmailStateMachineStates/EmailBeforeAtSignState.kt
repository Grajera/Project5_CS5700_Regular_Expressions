package EmailStateMachineStates

import regular_expressions.BadState
import regular_expressions.State

/**
 * Represents the first step in the email validation process.
 */
object EmailBeforeAtSignState : State {
    override fun tokenize(token: String): State = when {
        token == " " -> BadState() // Invalid if space is encountered
        token == "@" -> EmailAfterAtSignState // Move to step 2 if '@' is found
        else -> EmailBeforeAtSignState // Stay in this state
    }
}
