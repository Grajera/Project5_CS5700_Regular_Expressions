package project5

import BinaryStateMachineStates.BinaryStartingState
import EmailStateMachineStates.EmailStartingState
import FloatingPointStateStates.FloatingPointStartState
import IntegerStateMachineStates.InitialIntegerState
import project5.Interfaces.State
import project5.password.PasswordStartingState

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
