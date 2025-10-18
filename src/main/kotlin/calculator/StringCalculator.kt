package calculator

class StringCalculator(
    private val parser: DelimiterParser = DelimiterParser()
) {

    fun calculator(input: String) {
        if (input.isEmpty())
            return // Exception or 0

        val customDelimiter = parser.extractCustomDelimiter(input)
        val numberPart = parser.extractNumberPart(input, customDelimiter)

        val numberList = split(numberPart, customDelimiter).map { it.toInt() }

        print(numberList)
    }

    private fun split(numberPart: String, customDelimiter: String?): List<String> {
        return if (customDelimiter == null) {
            numberPart.split(",", ":")
        } else {
            numberPart.split(customDelimiter)
        }
    }
}