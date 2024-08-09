package EmailStateMachineStates

import project5.BadState
import project5.Interfaces.State

object EmailBeforeAtSignState : State {
    override fun tokenize(token: String): State = when {
        token == " " -> BadState() // Invalid if space is encountered
        token == "@" -> EmailAfterAtSignState // Move to step 2 if '@' is found
        else -> EmailBeforeAtSignState // Stay in this state
    }
}
