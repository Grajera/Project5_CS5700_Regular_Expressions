package regular_expressions

class BadState : State {
    override fun next(char: String): State = BadState()
}
