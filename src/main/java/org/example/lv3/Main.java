package org.example.lv3;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculator calculator = new Calculator();

        while (true) {
            try {
                System.out.println("::: 계산 프로그램을 시작합니다. :::");
                System.out.print("첫 번째 숫자를 입력하세요: ");
                double num1 = sc.nextDouble();

                System.out.print("두 번째 숫자를 입력하세요: ");
                double num2 = sc.nextDouble();

                System.out.print("연산자 (+, -, *, /)를 입력하세요: ");
                char symbol = sc.next().charAt(0);

                double result = calculator.calculate(num1, num2, symbol);
                calculator.addResult(result); // 결과값을 담는다.

                System.out.println("결과: " + result);
            } catch (InputMismatchException e) {
                System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
            } catch (IllegalArgumentException | ArithmeticException e) {
                System.out.println("오류 발생: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("알 수 없는 오류가 발생했습니다.");
            } finally {
                sc.nextLine(); // 버퍼 비우기

                System.out.println("연산 결과 저장: " + calculator.getResultList());

                System.out.print("첫 번째 연산 결과를 삭제하시겠습니까? (y/n): ");
                String removeChoice = sc.nextLine();
                if (removeChoice.equalsIgnoreCase("y")) {
                    calculator.removeFirstIndexResult();

                    System.out.println("삭제 완료: " + calculator.getResultList());
                }

                System.out.print("계속하시겠습니까? (exit 입력 시 종료): ");
                String continueChoice = sc.nextLine();
                if (continueChoice.equalsIgnoreCase("exit")) {
                    System.out.println("::: 계산 프로그램을 종료합니다. :::");
                    break;
                }
            }
        }

        try {
            System.out.println("::: 연산 결과 조회를 시작합니다. :::");
            System.out.print("연산 결과 중 입력한 숫자보다 큰 값들을 조회합니다. 숫자 입력: ");
            double inputValue = sc.nextDouble();
            List<Double> exceedingValuesList = calculator.printExceedingValues(inputValue);

            System.out.println(inputValue + " 보다 큰 값들을 조회: " + exceedingValuesList);
            System.out.println("::: 연산 결과 조회를 종료합니다. :::");
        } catch (InputMismatchException e) {
            System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
        }

        sc.close(); // Scanner 자원 해제
    }
}
