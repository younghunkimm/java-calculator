package org.example.lv2;

import java.util.ArrayList;

public class Calculator {
    // === 속성 ===
    private int firstNumber; // 첫 번째 숫자
    private int secondNumber; // 두 번째 숫자
    private char operator; // 연산자

    public boolean isOperate = true; // 계산 가능 여부

    // 연산 결과를 저장하는 컬렉션 타입 필드 선언 및 생성
    private ArrayList<Integer> list = new ArrayList<>();

    // === 생성자 ===
    public Calculator(int firstNumber, int secondNumber, char operator) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.operator = operator;
    }

    // === 기능 ===
    public int calculate() {
        int result = 0;

        switch (operator) {
            case '+':
                result = firstNumber + secondNumber;
                break;
            case '-':
                result = firstNumber - secondNumber;
                break;
            case '*':
                result = firstNumber * secondNumber;
                break;
            case '/':
                if (secondNumber == 0) {
                    System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                    isOperate = false;
                } else {
                    result = firstNumber / secondNumber;
                }
                break;
            default:
                System.out.println("올바른 연산자를 입력해주세요.");
                isOperate = false;
                break;
        }

        // 연산이 정상적으로 수행됐다면 list 컬렉션에 추가
        if (isOperate) {
            list.add(result);
        }

        return result;
    }

    // Calculator 클래스에 저장된 연산 결과들 중 가장 먼저 저장된 데이터를 삭제하는 기능
    public void removeResult() {
        // 리스트가 비어있는데 remove(0) 을 호출하면 IndexOutOfBoundsException 발생
        if (!list.isEmpty()) {
            list.remove(0);
        }
    }

    // Getter
    public ArrayList<Integer> getList() {
        return list;
    }
}
