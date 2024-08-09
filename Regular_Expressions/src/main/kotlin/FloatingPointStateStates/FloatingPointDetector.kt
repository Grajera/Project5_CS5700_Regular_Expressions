package detectors.Detectors

import regular_expressions.Detector
import regular_expressions.StateMachineFactory
import regular_expressions.Verification

class FloatingPointDetector : Detector {
    private val stateMachine = StateMachineFactory().createStateMachine("floatingPoint")!!

    override fun isValid(input: String): Boolean {
        return Verification().verify(input, stateMachine)
    }
}