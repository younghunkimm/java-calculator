package org.example.lv3;

public class Main {
    public static void main(String[] args) {
        for (OperatorType operatorType : OperatorType.values()) {
            System.out.println("operatorType = " + operatorType);
            System.out.println("operatorType.getSymbol = " + operatorType.getSymbol());
            System.out.println("operatorType.getFormula() = " + operatorType.getFormula());
        }
    }
}
