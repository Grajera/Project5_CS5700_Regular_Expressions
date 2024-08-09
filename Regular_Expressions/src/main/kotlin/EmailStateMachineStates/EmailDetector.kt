package detectors.Detectors

import project5.Interfaces.Detector
import project5.StateMachineFactory
import project5.VerifiedState

class EmailDetector : Detector {
    private val stateMachine = StateMachineFactory().createStateMachine("email")!!

    override fun isValid(input: String): Boolean {
        return VerifiedState().verify(input, stateMachine)
    }
}