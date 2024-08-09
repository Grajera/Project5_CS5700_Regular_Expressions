package regular_expressions.password

import regular_expressions.BadState
import regular_expressions.State

class PasswordSpecialCharacterState : State {
    override fun tokenize(token: String): State {
        return when {
            token == " " -> BadState()
            token in "ABCDEFGHIJKLMNOPQRSTUVWXYZ" -> PasswordValidated()
            else -> PasswordSpecialCharacterState()
        }
    }
}
