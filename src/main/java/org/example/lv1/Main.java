package org.example.lv1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("첫 번째 숫자를 입력하세요: ");
            int firstNumber = sc.nextInt();

            System.out.print("두 번째 숫자를 입력하세요: ");
            int secondNumber = sc.nextInt();

            // System.out.println("firstNumber = " + firstNumber);
            // System.out.println("secondNumber = " + secondNumber);

            System.out.print("사칙연산 기호를 입력하세요(+,-,*,/): ");
            char symbol = sc.next().charAt(0); // String 을 받은 후 char 형으로 변환

            // System.out.println("symbol = " + symbol);

            int result = 0; // 결과값
            boolean exitWhile = false; // 연산 오류 체크

            switch (symbol) {
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
                        exitWhile = true;
                    } else {
                        result = firstNumber / secondNumber;
                    }
                    break;
                default:
                    System.out.println("올바른 연산자를 입력해주세요.");
                    exitWhile = true;
                    break;
            }

            if (exitWhile) break;

            System.out.println("결과 = " + result);

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            if (sc.next().equals("exit")) break;
        }

        sc.close();
    }
}
