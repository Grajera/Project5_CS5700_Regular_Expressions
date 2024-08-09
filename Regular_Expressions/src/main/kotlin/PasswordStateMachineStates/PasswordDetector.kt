package detectors.Detectors

import project5.Interfaces.Detector
import project5.StateMachineFactory
import project5.VerifiedState

class PasswordDetector : Detector {
    private val stateMachine = StateMachineFactory().createStateMachine("password")!!

    override fun isValid(input: String): Boolean {
        return VerifiedState().authenticate(input, stateMachine)
    }
}