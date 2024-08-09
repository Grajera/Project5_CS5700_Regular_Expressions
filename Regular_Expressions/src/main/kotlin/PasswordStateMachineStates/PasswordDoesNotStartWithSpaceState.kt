package project5.password

import project5.BadState
import project5.Interfaces.State

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
