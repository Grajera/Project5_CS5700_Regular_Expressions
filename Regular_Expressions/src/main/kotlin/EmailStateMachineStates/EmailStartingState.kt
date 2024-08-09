package EmailStateMachineStates

import project5.BadState
import project5.Interfaces.State

object EmailStartingState : State {
    override fun tokenize(token: String): State = when {
        token == " " || token == "@" -> BadState() // Invalid if space or '@' is encountered
        else -> EmailBeforeAtSignState // Move to the first email step state
    }
}
