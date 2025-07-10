package org.example.lv3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    // resultList 컬렉션에 저장된 연산 결과들 중 가장 먼저 저장된 데이터를 삭제하는 기능
    public void removeFirstIndexResult() {
        // 리스트가 비어있는데 remove(0) 을 호출하면 IndexOutOfBoundsException 발생
        if (!resultList.isEmpty()) { // 예외 방지
            resultList.remove(0);
        }
    }

    // 저장된 연산 결과들 중 사용자가 입력한 값보다 큰 값들을 출력하는 기능
    public List<Double> printExceedingValues(double inputValue) {
        return resultList.stream()
                .filter(result -> result > inputValue)
                .collect(Collectors.toList());
    }
}
