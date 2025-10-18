package calculator

fun main() {
    val inputView = InputView()
    val parser = DelimiterParser()

    val input = inputView.readInput()

    if (input.isEmpty())
        return // Exception or 0

    val customDelimiter = parser.extractCustomDelimiter(input)
    val numberPart = parser.extractNumberPart(input, customDelimiter)

    println("customDelimiter : $customDelimiter")
    println("numberPart : $numberPart")
}
