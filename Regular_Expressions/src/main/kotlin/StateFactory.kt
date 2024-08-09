package regular_expressions

import regular_expressions.binary.BinaryStartingState
import regular_expressions.email.EmailStartingState
import regular_expressions.floating.FloatingPointStartState
import regular_expressions.integer.IntegerStartingState
import regular_expressions.password.PasswordStartingState

class FirstStateFactory {
    private val firstStates = mapOf(
        "integer" to IntegerStartingState(),
        "float" to FloatingPointStartState(),
        "binary" to BinaryStartingState(),
        "email" to EmailStartingState(),
        "password" to PasswordStartingState()
    )

    fun createFirstState(type: String): State? = firstStates[type]
}
