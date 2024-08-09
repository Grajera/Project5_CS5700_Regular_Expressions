package BinaryStateMachineStates

import project5.BadState
import project5.Interfaces.State

class BinaryZeroState : State {
    override fun tokenize(token: String): State = when {
        token == "1" -> BinaryVerified()
        token == "0" -> BinaryZeroState()
        else -> BadState()
    }
}