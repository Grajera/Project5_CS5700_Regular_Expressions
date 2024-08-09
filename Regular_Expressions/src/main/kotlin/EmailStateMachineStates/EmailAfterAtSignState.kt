package EmailStateMachineStates

import regular_expressions.BadState
import regular_expressions.State

/**
 * Represents the second step in the email validation process.
 */
object EmailAfterAtSignState : State {
    override fun tokenize(token: String): State = when {
        token == " " || token == "@" -> BadState() // Invalid if space or another '@' is encountered
        token == "." -> EmailAfterPeriodState // Move to step 3 if '.' is found
        else -> EmailAfterAtSignState // Stay in this state
    }
}
