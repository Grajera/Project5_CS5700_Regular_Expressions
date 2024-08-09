package IntegerStateMachineStates

import project5.BadState
import project5.Interfaces.State
import project5.Interfaces.Verification

object IntegerVerified : State, Verification {
    override fun tokenize(token: String): State = when {
        token in "0123456789" -> IntegerVerified // Continue accepting digits
        else -> BadState() // Invalid input
    }
}
