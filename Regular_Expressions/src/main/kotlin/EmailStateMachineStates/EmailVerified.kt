package EmailStateMachineStates

import project5.BadState
import project5.Interfaces.State
import project5.Interfaces.Verification

object EmailVerified : State, Verification {
    override fun tokenize(token: String): State = when {
        token == " " || token == "@" || token == "." -> BadState() // Invalid if space, '@', or '.' is found
        else -> EmailVerified // Stay in the valid state
    }
}
