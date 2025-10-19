package calculator

class InputValidator {
    fun validateAndConvert(parts: List<String>): List<Int> {
        return parts.map { part ->
            if (part.isEmpty()) {
                throw IllegalArgumentException("구분자 사용이 잘못되었습니다.")
            }

            val number = part.toIntOrNull() ?: throw IllegalArgumentException("입력 값이 숫자가 아닌 값이 있습니다.")

            if (number <= 0) {
                throw IllegalArgumentException("입력된 값에 양수가 아닌 수가 있습니다.")
            }

            number
        }
    }
}