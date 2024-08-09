package detectors.Detectors

import regular_expressions.Detector
import regular_expressions.StateMachineFactory
import regular_expressions.Verification

class BinaryNumberDetector : Detector {
    private val stateMachine = StateMachineFactory().createStateMachine("binary")!!

    override fun isValid(input: String): Boolean {
        return Verification().verify(input, stateMachine)
    }
}
