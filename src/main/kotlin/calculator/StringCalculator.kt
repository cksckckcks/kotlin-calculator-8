package calculator

import java.math.BigInteger

class StringCalculator(
    private val parser: DelimiterParser = DelimiterParser(),
    private val validator: InputValidator = InputValidator(),
    private val outputView: OutputView = OutputView()
) {
    fun calculator(input: String) {
        if (input.isEmpty()) {
            outputView.printResult(BigInteger.ZERO)

            return
        }

        val customDelimiter = parser.extractCustomDelimiter(input)
        val numberPart = parser.extractNumberPart(input, customDelimiter)

        val numberList = split(numberPart, customDelimiter)

        val bigIntNumberList = validator.validateAndConvert(numberList)

        val result = bigIntNumberList.fold(BigInteger.ZERO) { acc, bigIntNum -> acc.add(bigIntNum) }

        outputView.printResult(result)
    }

    private fun split(numberPart: String, customDelimiter: String?): List<String> {
        return if (customDelimiter == null) {
            numberPart.split(",", ":")
        } else {
            numberPart.split(customDelimiter)
        }
    }
}