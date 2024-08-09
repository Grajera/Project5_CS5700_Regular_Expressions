package EmailStateMachineStates

import regular_expressions.BadState
import regular_expressions.State

/**
 * Represents the third step in the email validation process.
 */
object EmailAfterPeriodState : State {
    override fun next(char: String): State = when {
        char == " " || char == "@" || char == "." -> BadState() // Invalid if space, '@', or '.' is found
        else -> EmailValidated // Move to valid state if conditions are met
    }
}
