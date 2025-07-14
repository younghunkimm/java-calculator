package org.example.lv3;

import org.example.lv3.calculator.ArithmeticCalculator;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArithmeticCalculator<Double> arithmeticCalculator = new ArithmeticCalculator<>(); // 계산기 객체 생성
        List<Double> resultList = new ArrayList<>(); // 결과값이 담길 리스트 생성

        // running의 값이 false가 되면 while문의 종료된다.
        boolean running = true;

        do {
            System.out.println("::: 프로그램 시작 :::");
            System.out.println("1. 사칙연산 계산");
            System.out.println("2. 결과값 조회");
            System.out.println("3. 오래된 결과값 제거");
            System.out.println("4. 프로그램 종료");

            try {
                System.out.print("번호를 입력하세요 : ");
                int input = sc.nextInt();

                switch (input) {
                    case 1:
                        System.out.println("::: 사칙연산 계산 시작 :::");
                        System.out.print("첫 번째 숫자를 입력해주세요 : ");
                        double num1 = sc.nextDouble();

                        System.out.print("연산자를 입력해주세요(+,-,*,/) : ");
                        char symbol = sc.next().charAt(0);

                        System.out.print("두 번째 숫자를 입력해주세요 : ");
                        double num2 = sc.nextDouble();

                        double result = arithmeticCalculator.calculate(num1, num2, symbol);
                        System.out.println("결과값 = " + result);

                        resultList.add(result); // 결과값을 담는다.
                        break;
                    case 2:
                        System.out.println("::: 결과값 조회 시작 :::");
                        System.out.print("조회할 숫자를 입력해주세요(입력값보다 큰 값들이 조회됩니다) : ");
                        double standardValue = sc.nextDouble();

                        List<Double> findList = arithmeticCalculator.find(resultList, standardValue);

                        System.out.println(standardValue + " 보다 큰 결과값들의 목록 : " + findList);
                        break;
                    case 3:
                        arithmeticCalculator.remove(resultList, 0);
                        break;
                    case 4:
                        // 프로그램 종료
                        System.out.println("프로그램을 종료합니다.");
                        running = false;
                        break;
                    default:
                        System.out.println("존재하지 않는 옵션입니다.");
                }
            } catch (InputMismatchException e) {
                System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
            } catch (Exception e) {
                sc.nextLine(); // 버퍼 비우기

                System.out.println(e.getMessage());
            }
        } while (running);

        sc.close();
    }
}
