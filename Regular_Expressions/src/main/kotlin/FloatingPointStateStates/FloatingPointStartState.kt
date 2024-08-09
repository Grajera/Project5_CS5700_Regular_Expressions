package FloatingPointStateStates

import project5.BadState
import project5.Interfaces.State

object FloatingPointStartState : State {
    override fun tokenize(token: String): State = when {
        token == "0" -> FloatingPointAfterZeroStartState // '0' followed by a period is valid
        token == "." -> FloatingPointAfterPeriodState // Period can start the float
        token in "123456789" -> FloatingPointNonZeroDigitState // Valid float can start with a non-zero digit
        else -> BadState() // Invalid input
    }
}
