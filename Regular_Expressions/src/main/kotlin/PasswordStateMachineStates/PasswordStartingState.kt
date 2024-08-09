package regular_expressions.password

import regular_expressions.BadState
import regular_expressions.State

object PasswordStartingState : State {
    override fun tokenize(token: String): State {
        return if (token == " ") BadState() else PasswordDoesNotStartWithSpaceState()
    }
}
