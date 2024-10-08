package EmailStateMachineStates

import project5.BadState
import project5.Interfaces.State

object EmailAfterPeriodState : State {
    override fun tokenize(token: String): State = when {
        token == " " || token == "@" || token == "." -> BadState() // Invalid if space, '@', or '.' is found
        else -> EmailVerified // Move to valid state if conditions are met
    }
}
