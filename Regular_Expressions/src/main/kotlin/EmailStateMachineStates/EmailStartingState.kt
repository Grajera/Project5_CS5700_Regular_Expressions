package EmailStateMachineStates

import regular_expressions.BadState
import regular_expressions.State

/**
 * Represents the initial state in the email validation process.
 */
object EmailStartingState : State {
    override fun tokenize(token: String): State = when {
        token == " " || token == "@" -> BadState() // Invalid if space or '@' is encountered
        else -> EmailBeforeAtSignState // Move to the first email step state
    }
}
