package FloatingPointStateStates

import project5.BadState
import project5.Interfaces.State

object FloatingPointAfterPeriodState : State {
    override fun tokenize(token: String): State = when {
        token in "0123456789" -> FloatingPointVerified // Valid if digits follow the period
        else -> BadState() // Any other character is invalid
    }
}