package Validators

class IntegerValidator : ValidationStrategy {
    override fun isValid(input: String): Boolean {
        // An integer must not be empty
        if (input.isEmpty()) {
            return false
        }

        // The first character must be a digit (1-9)
        if (input[0] == '0') {
            return false
        }

        // Check that all characters are digits (0-9)
        return input.all { it.isDigit() }
    }
}
