package org.example.lv2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("첫 번째 숫자를 입력하세요: ");
            int firstNumber = sc.nextInt();

            System.out.print("두 번째 숫자를 입력하세요: ");
            int secondNumber = sc.nextInt();

            System.out.print("사칙연산 기호를 입력하세요(+,-,*,/): ");
            char operator = sc.next().charAt(0); // String 을 받은 후 char 형으로 변환

            Calculator calculator = new Calculator(firstNumber, secondNumber, operator);
            int result = calculator.calculate();

            if (calculator.isOperate) {
                System.out.println("결과 = " + result);
            } else {
                continue;
            }

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            if (sc.next().equals("exit")) break;
        }

        sc.close();
    }
}
