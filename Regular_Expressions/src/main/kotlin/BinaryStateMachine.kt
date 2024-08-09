package regular_expressions.binary

import regular_expressions.Invalid
import regular_expressions.State

class BinaryStartingState : State {
    override fun next(char: String): State = if (char == "1") Valid() else Invalid()
}

class BinaryState1 : State {
    override fun next(char: String): State = when {
        char == "1" -> Valid()
        char == "0" -> BinaryState1()
        else -> Invalid()
    }
}

class Valid : State, regular_expressions.Valid {
    override fun next(char: String): State = when {
        char == "1" -> Valid()
        char == "0" -> BinaryState1()
        else -> Invalid()
    }
}
