package regular_expressions

interface State {
    fun next(char: String): State
}
