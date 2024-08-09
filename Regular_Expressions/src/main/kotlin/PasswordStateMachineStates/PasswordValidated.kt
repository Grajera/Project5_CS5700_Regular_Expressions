package regular_expressions.password

import regular_expressions.*

class PasswordValidated : State, Validation {
    override fun tokenize(token: String): State {
        return when {
            token == " " -> BadState()
            token in "~`!@#$%^&*()_-=+}{[]|\\\"':;<,>.?/" -> PasswordMiddleCharacterSpecialState()
            else -> PasswordValidated()
        }
    }
}
