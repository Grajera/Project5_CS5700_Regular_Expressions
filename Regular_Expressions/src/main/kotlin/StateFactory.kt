package regular_expressions

import BinaryStateMachineStates.BinaryStartingState
import EmailStateMachineStates.EmailStartingState
import FloatingPointStateStates.FloatingPointStartState
import IntegerStateMachineStates.InitialIntegerState
import PasswordStateMachineStates.PasswordStartingState

class StateMachineFactory {
    private val stateMachines = mapOf(
        "integer" to InitialIntegerState,
        "float" to FloatingPointStartState,
        "binary" to BinaryStartingState,
        "email" to EmailStartingState,
        "password" to PasswordStartingState
    )

    fun crateStateMachine(type: String): State? = stateMachines[type]
}
