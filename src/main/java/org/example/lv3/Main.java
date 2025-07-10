package org.example.lv3;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        double result = calculator.calculate(1, 2, '+');
        System.out.println("result = " + result);
    }
}
