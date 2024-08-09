package project5.password

import project5.BadState
import project5.Interfaces.State

class PasswordCapitalLetterState : State {
    override fun tokenize(token: String): State {
        return when {
            token == " " -> BadState()
            token in "~`!@#$%^&*()_-=+}{[]|\\\"':;<,>.?/" -> PasswordMiddleCharacterSpecialState()
            else -> PasswordCapitalLetterState()
        }
    }
}
