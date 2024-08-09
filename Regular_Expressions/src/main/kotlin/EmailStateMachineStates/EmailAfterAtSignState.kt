package EmailStateMachineStates

import project5.BadState
import project5.Interfaces.State

object EmailAfterAtSignState : State {
    override fun tokenize(token: String): State = when {
        token == " " || token == "@" -> BadState() // Invalid if space or another '@' is encountered
        token == "." -> EmailAfterPeriodState // Move to step 3 if '.' is found
        else -> EmailAfterAtSignState // Stay in this state
    }
}
