package regular_expressions

open class Verifier {
    open fun verify(sequence: String, first: State): Boolean {
        var state = first
        for (char in sequence) {
            state = state.next(char.toString())
        }
        return state is Valid
    }
}
