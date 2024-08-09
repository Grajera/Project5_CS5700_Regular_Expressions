package regular_expressions

open class Verification {
    open fun verify(tokens: String, initialState: State): Boolean {
        var state: State = initialState
        for (token in tokens) {
            state = state.tokenize(token.toString())
        }
        return state is Validation
    }
}
