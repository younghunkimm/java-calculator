package org.example.lv3.calculator;

public interface Calculator<T extends Number> {
    Double calculate(T num1, T num2, char symbol);
}
