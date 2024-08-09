package EmailStateMachineStates

import regular_expressions.BadState
import regular_expressions.State

/**
 * Represents the initial state in the email validation process.
 */
object EmailStartingState : State {
    override fun next(char: String): State = when {
        char == " " || char == "@" -> BadState() // Invalid if space or '@' is encountered
        else -> EmailBeforeAtSignState // Move to the first email step state
    }
}
