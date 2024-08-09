package Validators

class PasswordValidator : ValidationStrategy {
    override fun isValid(input: String): Boolean {
        if (input.length < 8) return false // Minimum length
        if (input.last() in "!@#$%&*") return false // Cannot end with a special character

        var hasUpperCase = false
        var hasSpecialChar = false

        for (char in input) {
            if (char.isUpperCase()) hasUpperCase = true
            if (char in "!@#$%&*") hasSpecialChar = true
        }

        return hasUpperCase && hasSpecialChar
    }
}
