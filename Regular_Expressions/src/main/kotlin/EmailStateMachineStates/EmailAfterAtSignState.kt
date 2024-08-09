package EmailStateMachineStates

import regular_expressions.BadState
import regular_expressions.State

/**
 * Represents the second step in the email validation process.
 */
object EmailAfterAtSignState : State {
    override fun next(char: String): State = when {
        char == " " || char == "@" -> BadState() // Invalid if space or another '@' is encountered
        char == "." -> EmailAfterPeriodState // Move to step 3 if '.' is found
        else -> EmailAfterAtSignState // Stay in this state
    }
}
