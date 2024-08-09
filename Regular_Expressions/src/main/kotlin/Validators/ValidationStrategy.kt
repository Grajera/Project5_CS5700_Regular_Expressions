package Validators

interface ValidationStrategy {
    fun isValid(input: String): Boolean
}
