package calculator

class StringCalculator(
    private val parser: DelimiterParser = DelimiterParser(),
    private val validator: InputValidator = InputValidator()
) {

    fun calculator(input: String) {
        if (input.isEmpty())
            return // Exception or 0

        val customDelimiter = parser.extractCustomDelimiter(input)
        val numberPart = parser.extractNumberPart(input, customDelimiter)

        val numberList = split(numberPart, customDelimiter)

        val intNumberList = validator.validateAndConvert(numberList)

        print(intNumberList)
    }

    private fun split(numberPart: String, customDelimiter: String?): List<String> {
        return if (customDelimiter == null) {
            numberPart.split(",", ":")
        } else {
            numberPart.split(customDelimiter)
        }
    }
}