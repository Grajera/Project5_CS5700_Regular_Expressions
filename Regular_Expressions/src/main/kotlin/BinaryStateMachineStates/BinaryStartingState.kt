package BinaryStateMachineStates

import project5.BadState
import project5.Interfaces.State

object BinaryStartingState : State {
    override fun tokenize(token: String): State = when {
        token == "1" -> BinaryVerified()// Valid if starting with a '1'
        else -> BadState() // Invalid input
    }
}
