package com.aca.calculator;

import java.util.Scanner;

public class Calculator2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please type the expression");
        double firstNumber = Integer.parseInt(scanner.next());
        String operator = scanner.next();
        double secondNumber = Integer.parseInt(scanner.next());
        double result = calculate(firstNumber, operator, secondNumber);
        System.out.println(String.format("%s %s %s = %s", firstNumber, operator, secondNumber, result));
    }

    static double calculate(double a, String operation, double b) {
        switch (operation) {
            case "*":
                return a * b;
            case "/":
                return a / b;
            case "-":
                return a - b;
            case "+":
                return a + b;
            default:
                throw new IllegalArgumentException("No such operation");
        }
    }

}
