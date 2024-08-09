package regular_expressions

interface State {
    fun tokenize(token: String): State
}
