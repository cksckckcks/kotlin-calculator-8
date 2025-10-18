package calculator

fun main() {
    val inputView = InputView()
    val stringCalculator = StringCalculator()

    val input = inputView.readInput()

    stringCalculator.calculator(input)
}
