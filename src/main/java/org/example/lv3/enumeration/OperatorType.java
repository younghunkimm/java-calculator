package org.example.lv3.enumeration;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum OperatorType {
    PLUS('+', (a, b) -> a + b),
    MINUS('-',  (a, b) -> a - b),
    MULTIPLY('*',  (a, b) -> a * b),
    DIVIDE('/',   (a, b) -> {
        if (b == 0) {
            throw new ArithmeticException("0 으로 나눌 수 없습니다.");
        }
        return a / b;
    });

    private final char symbol;
    private final BiFunction<Double, Double, Double> formula;

    /**
     * 생성자
     *
     * @param symbol 사칙연산 기호
     * @param formula 자바에서 제공하는 함수형 인터페이스 <데이터타입, 데이터타입, 반환타입>
     */
    OperatorType(char symbol, BiFunction<Double, Double, Double> formula) {
        this.symbol = symbol;
        this.formula = formula;
    }

    // 기능
    // Getter: 연산자 기호 값을 가져온다.
    public char getSymbol() {
        return symbol;
    }

    // BiFunction 의 `apply` 메서드가 생성자를 통해 정의된 `Lambda` 로 `@Override` 된다.
    public double apply(double a, double b) {
        return formula.apply(a, b);
    }

    // 사용자에게 입력받은 연산자 기호를 통해 인스턴스를 반환한다.
    public static OperatorType fromSymbol(char symbol) {
        return Arrays.stream(OperatorType.values())
                .filter(op -> op.getSymbol() == symbol)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 연산자입니다: " + symbol));
    }
}
