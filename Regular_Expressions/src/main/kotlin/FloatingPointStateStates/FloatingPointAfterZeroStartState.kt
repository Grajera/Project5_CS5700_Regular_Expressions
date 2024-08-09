package FloatingPointStateStates

import project5.BadState
import project5.Interfaces.State

object FloatingPointAfterZeroStartState : State {
    override fun tokenize(token: String): State = when {
        token in "." -> FloatingPointAfterPeriodState // Valid if digits follow the period
        else -> BadState() // Any other character is invalid
    }
}