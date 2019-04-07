package com.aca.calculator;

import java.util.Scanner;

public class Calculator3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please type the expression");
        //3 + 4 * 2
        String expression = scanner.nextLine();
        // 4 * 2
        String mostPrioritizedSubExpression = findMostPrioritizedSubExpression(expression);
        // 8
        String subExpressionResult = calculate(mostPrioritizedSubExpression);
        //3 + 8
        String replace = expression.replace(mostPrioritizedSubExpression, subExpressionResult);
        //11
        String result = calculate(replace);

        System.out.println(expression + " = " + result);
    }

    static String findMostPrioritizedSubExpression(String expression) {
        //[3,+,4,*,2]
        String[] s = expression.split(" ");
        if ("*/".contains(s[1])) {
            return expression.substring(0, 5);
        } else {
            //4 * 2
            return expression.substring(4);
        }
    }

    static String calculate(String expression) {
        String[] array = expression.split(" ");
        return "" + calculate(Double.parseDouble(array[0]), array[1], Double.parseDouble(array[2]));
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
