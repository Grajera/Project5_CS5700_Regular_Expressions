package FloatingPointStateStates

import project5.BadState
import project5.Interfaces.State

object FloatingPointNonZeroDigitState : State {
    override fun tokenize(token: String): State = when {
        token == "." -> FloatingPointAfterPeriodState // Move to step 2 if '.' is found
        token in "0123456789" -> FloatingPointNonZeroDigitState // Continue accepting digits
        else -> BadState() // Invalid input
    }
}
