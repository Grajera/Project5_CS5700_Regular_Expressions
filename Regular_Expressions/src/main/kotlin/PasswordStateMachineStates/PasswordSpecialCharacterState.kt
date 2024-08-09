package project5.password

import project5.BadState
import project5.Interfaces.State

class PasswordSpecialCharacterState : State {
    override fun tokenize(token: String): State {
        return when {
            token == " " -> BadState()
            token in "ABCDEFGHIJKLMNOPQRSTUVWXYZ" -> PasswordVerified()
            else -> PasswordSpecialCharacterState()
        }
    }
}
