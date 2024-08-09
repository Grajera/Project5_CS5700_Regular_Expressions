package regular_expressions

class BadState : State {
    override fun tokenize(token: String): State = this
}
