package detectors.Detectors

import regular_expressions.Detector
import regular_expressions.StateMachineFactory
import regular_expressions.Verification

class EmailDetector : Detector {
    private val stateMachine = StateMachineFactory().createStateMachine("email")!!

    override fun isValid(input: String): Boolean {
        return Verification().verify(input, stateMachine)
    }
}