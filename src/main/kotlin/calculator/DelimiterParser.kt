package calculator

class DelimiterParser {
    fun extractCustomDelimiter(input: String): String? {
        if (!input.startsWith("//")) {
            return null
        }

        val customDelimiterEndIdx = input.indexOf("\\n")

        if (customDelimiterEndIdx == -1) {
            throw IllegalArgumentException("커스텀 구분자 형식에 오류가 있습니다.")
        }

        val customDelimiter = input.substring(2, customDelimiterEndIdx)

        if (customDelimiter.length != 1) {
            throw IllegalArgumentException("구분자는 1글자여야 합니다.")
        }

        return customDelimiter
    }

    fun extractNumberPart(input: String, customDelimiter: String?): String {
        return if (customDelimiter != null) {
            input.substring(input.indexOf("\\n") + 2)
        } else {
            input
        }
    }
}