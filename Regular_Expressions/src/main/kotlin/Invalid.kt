package regular_expressions

class Invalid : State {
    override fun next(char: String): State = Invalid()
}
