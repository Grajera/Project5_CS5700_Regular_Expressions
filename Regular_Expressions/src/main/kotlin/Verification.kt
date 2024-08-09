package regular_expressions

open class Verification {
    open fun verify(sequence: String, first: State): Boolean {
        var state = first
        for (char in sequence) {
            state = state.next(char.toString())
        }
        return state is Validation
    }
}
