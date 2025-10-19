package calculator

class InputValidator {
    fun validateAndConvert(parts: List<String>): List<Int> {
        return parts.map { part ->
            if (part.isEmpty()) {
                // Exception
            }

            val num = part.toIntOrNull() ?: 0 // Exception

            if (num <= 0) {
                // Exception
            }
            
            num
        }
    }
}