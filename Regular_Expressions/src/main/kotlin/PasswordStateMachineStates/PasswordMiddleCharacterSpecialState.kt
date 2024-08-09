package regular_expressions.password

import regular_expressions.BadState
import regular_expressions.State

class PasswordMiddleCharacterSpecialState : State {
    override fun tokenize(token: String): State {
        return when {
            token == " " -> BadState()
            token in "~`!@#$%^&*()_-=+}{[]|\\\"':;<,>.?/" -> PasswordMiddleCharacterSpecialState()
            else -> PasswordValidated()
        }
    }
}
