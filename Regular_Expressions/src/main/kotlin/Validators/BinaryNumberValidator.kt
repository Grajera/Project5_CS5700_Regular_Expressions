package Validators

class BinaryNumberValidator : ValidationStrategy {
    override fun isValid(input: String): Boolean {
        if (input.isEmpty()) return false
        if (input.first() != '1' || input.last() != '1') return false // Must start and end with '1'

        return input.all { it == '0' || it == '1' }
    }
}
