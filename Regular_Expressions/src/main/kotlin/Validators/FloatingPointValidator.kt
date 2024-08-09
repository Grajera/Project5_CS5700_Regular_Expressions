package Validators

class FloatingPointValidator : ValidationStrategy {
    override fun isValid(input: String): Boolean {
        if (input.isEmpty()) return false
        var dotCount = 0

        if (input[0] == '0' && input.length > 1 && input[1] != '.') return false // If starts with 0, next must be '.'

        for (char in input) {
            when (char) {
                '.' -> {
                    dotCount++
                    if (dotCount > 1) return false // Only one period allowed
                }
                !in '0'..'9' -> return false // Must only contain digits and one period
            }
        }

        return dotCount == 1 && input.last() != '.'
    }
}
