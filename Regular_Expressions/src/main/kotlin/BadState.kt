package project5

import project5.Interfaces.State

class BadState : State {
    override fun tokenize(token: String): State = this
}
