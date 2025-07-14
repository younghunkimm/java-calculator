package org.example.lv3.calculator;

import org.example.lv3.enumeration.OperatorType;

import java.util.List;

public class ArithmeticCalculator<T extends Number> implements Calculator<T>, Find<T>, Remove<T> {
    // 속성

    // 생성자

    // 기능
    @Override
    public Double calculate(T num1, T num2, char symbol) {
        OperatorType operatorType = OperatorType.fromSymbol(symbol);

        return operatorType.apply(num1.doubleValue(), num2.doubleValue());
    }

    @Override
    public List<T> find(List<T> resultList, double standardValue) {
        return resultList.stream()
                .filter(x -> x.doubleValue() > standardValue)
                .toList();
    }

    @Override
    public void remove(List<T> resultList, int index) {
        if (resultList.isEmpty()) {
            System.out.println("삭제할 데이터가 없습니다.");
        } else {
            System.out.println("삭제 전 : " + resultList);
            resultList.remove(index);
            System.out.println("삭제 후 : " + resultList);
        }
    }
}
