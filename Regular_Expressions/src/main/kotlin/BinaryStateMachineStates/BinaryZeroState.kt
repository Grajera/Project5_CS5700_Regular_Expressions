package BinaryStateMachineStates

import regular_expressions.BadState
import regular_expressions.State

class BinaryZeroState : State {
    override fun tokenize(token: String): State = when {
        token == "1" -> BinaryValid()
        token == "0" -> BinaryZeroState()
        else -> BadState()
    }
}