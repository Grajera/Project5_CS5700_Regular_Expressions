package regular_expressions

import BinaryStateMachineStates.BinaryStartingState
import EmailStateMachineStates.EmailStartingState
import FloatingPointStateStates.FloatingPointStartState
import IntegerStateMachineStates.InitialIntegerState
import regular_expressions.password.PasswordStartingState

class StateMachineFactory {
    private val stateMachines = mapOf(
        "integer" to InitialIntegerState,
        "floatingPoint" to FloatingPointStartState,
        "binary" to BinaryStartingState,
        "email" to EmailStartingState,
        "password" to PasswordStartingState
    )

    fun createStateMachine(stateMachine: String): State? = stateMachines[stateMachine]
}
