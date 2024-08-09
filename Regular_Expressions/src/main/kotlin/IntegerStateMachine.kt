package regular_expressions.integer

import regular_expressions.Invalid
import regular_expressions.State

class IntegerStartingState : State {
    override fun next(char: String): State = if (char in "123456789") Valid() else Invalid()
}

class Valid : State, regular_expressions.Valid {
    override fun next(char: String): State = if (char in "0123456789") Valid() else Invalid()
}
