package Validators

class EmailValidator : ValidationStrategy {
    override fun isValid(input: String): Boolean {
        // Split the input into parts
        val parts = input.split("@")

        // Check for exactly one @ and ensure parts are non-empty
        if (parts.size != 2 || parts[0].isEmpty() || parts[1].isEmpty()) {
            return false
        }

        // Split part 2 by the period
        val subParts = parts[1].split(".")

        // Check that part2 has exactly two non-empty parts (one period)
        if (subParts.size != 2 || subParts.any { it.isEmpty() }) {
            return false
        }

        // Check for invalid characters (spaces and multiple @ or .)
        return input.all { it != ' ' }
    }
}
