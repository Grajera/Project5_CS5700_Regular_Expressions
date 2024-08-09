package regular_expressions.password

import regular_expressions.Invalid
import regular_expressions.State

class PasswordStartingState : State {
    override fun next(char: String): State = if (char == " ") Invalid() else PasswordStep1()
}

class PasswordStep1 : State {
    override fun next(char: String): State = when {
        char == " " -> Invalid()
        char in "ABCDEFGHIJKLMNOPQRSTUVWXYZ" -> PasswordStep2()
        char in "~`!@#$%^&*()_-=+}{[]|\\\"':;<,>.?/" -> PasswordStep3()
        else -> PasswordStep1()
    }
}

class PasswordStep2 : State {
    override fun next(char: String): State = when {
        char == " " -> Invalid()
        char in "~`!@#$%^&*()_-=+}{[]|\\\"':;<,>.?/" -> PasswordStep3()
        else -> PasswordStep2()
    }
}

class PasswordStep3 : State {
    override fun next(char: String): State = if (char == " ") Invalid() else if (char in "ABCDEFGHIJKLMNOPQRSTUVWXYZ") Valid() else PasswordStep3()
}

class PasswordStep4 : State {
    override fun next(char: String): State = when {
        char == " " -> Invalid()
        char in "~`!@#$%^&*()_-=+}{[]|\\\"':;<,>.?/" -> PasswordStep4()
        else -> Valid()
    }
}

class Valid : State, regular_expressions.Valid {
    override fun next(char: String): State = when {
        char == " " -> Invalid()
        char in "~`!@#$%^&*()_-=+}{[]|\\\"':;<,>.?/" -> PasswordStep4()
        else -> Valid()
    }
}
