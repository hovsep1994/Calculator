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
        String replace = expression.replace(mostPrioritizedSubExpression, subExpressionResult);
        //14
        String result = calculate(replace);

        System.out.println(expression + " = " + result);
    }

    static String findMostPrioritizedSubExpression(String expression) {
        if (expression.contains("(")) {
            return expression.substring(expression.indexOf("("), expression.indexOf(")") + 1);
        }
        String[] s = expression.split(" ");
        if ("*/".contains(s[1])) {
            return expression.substring(0, 5);
        } else {
            //4 * 2
            return expression.substring(4);
        }
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

}
