package project5.password

import project5.BadState
import project5.Interfaces.State

object PasswordStartingState : State {
    override fun tokenize(token: String): State {
        return if (token == " ") BadState() else PasswordDoesNotStartWithSpaceState()
    }
}
