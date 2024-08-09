package EmailStateMachineStates

import regular_expressions.BadState
import regular_expressions.State

/**
 * Represents the third step in the email validation process.
 */
object EmailAfterPeriodState : State {
    override fun tokenize(token: String): State = when {
        token == " " || token == "@" || token == "." -> BadState() // Invalid if space, '@', or '.' is found
        else -> EmailValidated // Move to valid state if conditions are met
    }
}
