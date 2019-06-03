package calculator

class Calculator {
    fun divide(numerator: Double, denominator: Double): Double {
        if (denominator == 0.0) {
            throw ArithmeticException("divide by zero error")
        }
        return numerator / denominator
    }
}