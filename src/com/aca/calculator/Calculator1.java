package com.aca.calculator;

import java.util.Scanner;

public class Calculator1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type first number");
        double firstNumber = scanner.nextInt();
        System.out.println("Type operation");
        String operator = scanner.next();
        System.out.println("Type second number");
        double secondNumber = scanner.nextInt();
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
