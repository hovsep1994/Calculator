package com.aca.calculator;

import java.util.Scanner;

public class Calculator4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please type the expression");
        //( 3 + 4 ) * 2
        String expression = scanner.nextLine();
        // 3 + 4
        String mostPrioritizedSubExpression = findMostPrioritizedSubExpression(expression);
        // 7
        String subExpressionResult = calculate(mostPrioritizedSubExpression);
        //7 * 2
        String finalExpression = expression.replace(mostPrioritizedSubExpression, subExpressionResult);
        String result;
        // This check is for two number expression
        // as if finalExpression is already a number then there is no need to calculate more
        if (isNumber(finalExpression)) {
            result = finalExpression;
        } else {
            //14
            result = calculate(finalExpression);
        }
        System.out.println(expression + " = " + result);
    }

    static String findMostPrioritizedSubExpression(String expression) {
        if (expression.contains("(")) {
            return expression.substring(expression.indexOf("("), expression.indexOf(")") + 1);
        }
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

    static String calculate(String expression) {
        expression = expression.replace("( ", "");
        expression = expression.replace(" )", "");
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

    static boolean isNumber(String expression) {
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
