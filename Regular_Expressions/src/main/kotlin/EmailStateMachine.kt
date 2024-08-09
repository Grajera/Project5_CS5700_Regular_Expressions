package regular_expressions.email

import regular_expressions.Invalid
import regular_expressions.State

class EmailStartingState : State {
    override fun next(char: String): State = if (char == " " || char == "@") Invalid() else EmailStep1()
}

class EmailStep1 : State {
    override fun next(char: String): State = when {
        char == " " -> Invalid()
        char == "@" -> EmailStep2()
        else -> EmailStep1()
    }
}

class EmailStep2 : State {
    override fun next(char: String): State = when {
        char == " " || char == "@" -> Invalid()
        char == "." -> EmailStep3()
        else -> EmailStep2()
    }
}

class EmailStep3 : State {
    override fun next(char: String): State = when {
        char == " " || char == "@" || char == "." -> Invalid()
        else -> Valid()
    }
}

class Valid : State, regular_expressions.Valid {
    override fun next(char: String): State = when {
        char == " " || char == "@" || char == "." -> Invalid()
        else -> Valid()
    }
}
