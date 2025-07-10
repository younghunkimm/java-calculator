package org.example.lv3;

public class Calculator {
    public double calculate(double num1, double num2, char symbol) {
        OperatorType operatorType = OperatorType.fromSymbol(symbol);

        return operatorType.getFormula().apply(num1, num2);
    }
}
