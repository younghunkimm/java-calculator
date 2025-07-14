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

    // 저장된 연산 결과들 중 사용자가 입력한 값보다 큰 값들을 출력하는 기능
    @Override
    public List<T> find(List<T> resultList, double standardValue) {
        return resultList.stream()
                .filter(x -> x.doubleValue() > standardValue)
                .toList();
    }

    // resultList 컬렉션에 저장된 연산 결과들 중 가장 먼저 저장된 데이터를 삭제하는 기능
    @Override
    public void remove(List<T> resultList, int index) {
        // 리스트가 비어있는데 remove(0) 을 호출하면 IndexOutOfBoundsException 발생
        if (resultList.isEmpty()) { // 리스트가 비어있다면 메세지 출력
            System.out.println("삭제할 데이터가 없습니다.");
        } else { // 비어있지 않다면 삭제 + 전,후 데이터 비교
            System.out.println("삭제 전 : " + resultList);
            resultList.remove(index);
            System.out.println("삭제 후 : " + resultList);
        }
    }
}
