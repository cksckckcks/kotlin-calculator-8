package calculator

class DelimiterParser {
    fun extractCustomDelimiter(input: String): String? {
        if (!input.matches(Regex("^//(.)\\\\n.*$"))) {
            return null
        }

        return input.substring(2, 3)
    }

    fun extractNumberPart(input: String, customDelimiter: String?): String {
        return if (customDelimiter != null) {
            input.substring(input.indexOf("\\n") + 2)
        } else {
            input
        }
    }
}