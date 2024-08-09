package BinaryStateMachineStates

import project5.BadState
import project5.Interfaces.State
import project5.Interfaces.Verification

class BinaryVerified : State, Verification {
    override fun tokenize(token: String): State = when {
        token == "1" -> BinaryVerified() // Continue accepting '1's
        token == "0" -> BinaryZeroState() // Accept '0's
        else -> BadState() // Any other character is invalid
    }
}
