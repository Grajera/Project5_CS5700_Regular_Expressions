package project5.password

import project5.*
import project5.Interfaces.State
import project5.Interfaces.Verification

class PasswordVerified : State, Verification {
    override fun tokenize(token: String): State {
        return when {
            token == " " -> BadState()
            token in "~`!@#$%^&*()_-=+}{[]|\\\"':;<,>.?/" -> PasswordMiddleCharacterSpecialState()
            else -> PasswordVerified()
        }
    }
}
