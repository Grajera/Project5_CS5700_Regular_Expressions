package project5

import project5.Interfaces.State
import project5.Interfaces.Verification

open class VerifiedState {
    open fun verify(tokens: String, initialState: State): Boolean {
        var state: State = initialState
        for (token in tokens) {
            state = state.tokenize(token.toString())
        }
        return state is Verification
    }
}
