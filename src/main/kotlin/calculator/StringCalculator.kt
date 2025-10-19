package calculator

class StringCalculator(
    private val parser: DelimiterParser = DelimiterParser(),
    private val validator: InputValidator = InputValidator(),
    private val outputView: OutputView = OutputView()
) {
    fun calculator(input: String) {
        if (input.isEmpty()) {
            outputView.printResult(0)

            return
        }

        val customDelimiter = parser.extractCustomDelimiter(input)
        val numberPart = parser.extractNumberPart(input, customDelimiter)

        val numberList = split(numberPart, customDelimiter)

        val intNumberList = validator.validateAndConvert(numberList)

        outputView.printResult(intNumberList.sum())
    }

    private fun split(numberPart: String, customDelimiter: String?): List<String> {
        return if (customDelimiter == null) {
            numberPart.split(",", ":")
        } else {
            numberPart.split(customDelimiter)
        }
    }
}