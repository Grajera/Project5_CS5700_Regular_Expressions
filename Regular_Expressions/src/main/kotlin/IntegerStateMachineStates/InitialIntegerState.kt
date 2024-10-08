package IntegerStateMachineStates

import project5.BadState
import project5.Interfaces.State

object InitialIntegerState : State {
    override fun tokenize(token: String): State = when {
        token in "123456789" -> IntegerVerified // Valid if starting with a non-zero digit
        else -> BadState() // Invalid input
    }
}
