package regular_expressions.password

import regular_expressions.BadState
import regular_expressions.State

class PasswordDoesNotStartWithSpaceState : State {
    override fun tokenize(token: String): State {
        return when {
            token == " " -> BadState()
            token in "ABCDEFGHIJKLMNOPQRSTUVWXYZ" -> PasswordCapitalLetterState()
            token in "~`!@#$%^&*()_-=+}{[]|\\\"':;<,>.?/" -> PasswordSpecialCharacterState()
            else -> PasswordDoesNotStartWithSpaceState()
        }
    }
}
