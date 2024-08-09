package regular_expressions.floating

import regular_expressions.Invalid
import regular_expressions.State

class FloatingPointStartState : State {
    override fun next(char: String): State = when {
        char == "0" -> FloatingPointStep1()
        char == "." -> FloatingPointStep2()
        char in "123456789" -> FloatingPointStep3()
        else -> Invalid()
    }
}

class FloatingPointStep1 : State {
    override fun next(char: String): State = when {
        char == "0" -> FloatingPointStep1()
        char == "." -> FloatingPointStep2()
        char in "123456789" -> FloatingPointStep3()
        else -> Invalid()
    }
}

class FloatingPointStep2 : State {
    override fun next(char: String): State = if (char in "0123456789") Valid() else Invalid()
}

class FloatingPointStep3 : State {
    override fun next(char: String): State = when {
        char == "." -> FloatingPointStep2()
        char in "0123456789" -> FloatingPointStep3()
        else -> Invalid()
    }
}

class Valid : State, regular_expressions.Valid {
    override fun next(char: String): State = if (char in "0123456789") Valid() else Invalid()
}
