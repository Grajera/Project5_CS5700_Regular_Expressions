package FloatingPointStateStates

import project5.BadState
import project5.Interfaces.State
import project5.Interfaces.Verification

object FloatingPointVerified : State, Verification {
    override fun tokenize(token: String): State = when {
        token in "0123456789" -> FloatingPointVerified // Continue to accept digits
        else -> BadState() // Any other character is invalid
    }
}
