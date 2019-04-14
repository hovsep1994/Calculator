package com.aca.calculator;

import java.util.Scanner;

public class Calculator5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please type the expression");
        String expression = scanner.nextLine();
//        String expression = "3 + 4 + 3 * 2 - 1";
        String result = calculateExpression(expression);
        System.out.println(expression + " = " + result);
    }

    private static String calculateExpression(String expression) {
        while (!isNumber(expression)) {
            String mostPrioritizedSubExpression = findMostPrioritizedSubExpression(expression);
            String subExpressionResult = calculate(mostPrioritizedSubExpression);
            expression = expression.replace(mostPrioritizedSubExpression, subExpressionResult);
        }
        return expression;
    }

    private static String findMostPrioritizedSubExpression(String expression) {
        String[] split = expression.split(" ");
        if (expression.contains("*") || expression.contains("/")) {
            for (int i = 0; i < split.length; i++) {
                if ("*/".contains(split[i])) {
                    return split[i - 1] + " " + split[i] + " " + split[i + 1];
                }
            }
        }
        return split[0] + " " + split[1] + " " + split[2];
    }

    private static String calculate(String expression) {
        String[] array = expression.split(" ");
        return "" + calculate(Double.parseDouble(array[0]), array[1], Double.parseDouble(array[2]));
    }

    private static double calculate(double a, String operation, double b) {
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

    private static boolean isNumber(String expression) {
        // Or you can do like this
        // return str.matches("-?\\d+(\\.\\d+)?");
        try {
            Double.parseDouble(expression);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
