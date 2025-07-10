package org.example.lv3;

import java.util.ArrayList;
import java.util.List;
public class Calculator {
    // 속성
    private final List<Double> resultList = new ArrayList<>(); // 결과값이 담길 컬렉션

    // 생성자

    // 기능
    public double calculate(double num1, double num2, char symbol) {
        OperatorType operatorType = OperatorType.fromSymbol(symbol);

        return operatorType.getFormula().apply(num1, num2);
    }

    public List<Double> getResultList() {
        return resultList;
    }

    // 결과값을 컬렉션에 넣는 기능
    public void addResult(double num) {
        resultList.add(num);
    }
}
