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
        String finalExpression = expression.replace(mostPrioritizedSubExpression, subExpressionResult);
        String result;
        // This check is for two number expression
        // as if finalExpression is already a number then there is no need to calculate more
        if (isNumber(finalExpression)) {
            result = finalExpression;
        } else {
            //11
            result = calculate(finalExpression);
        }
        System.out.println(expression + " = " + result);
    }

    static String findMostPrioritizedSubExpression(String expression) {
        //[3,+,4,*,2]
        String[] split = expression.split(" ");
        if ("*/".contains(split[1])) {
            return concatWithSpace(split[0], split[1], split[2]);
        } else {
            //4 * 2
            return concatWithSpace(split[2], split[3], split[4]);
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

    static String concatWithSpace(String... strings) {
        String result = "";
        for (int i = 0; i < strings.length; i++) {
            result += strings[i];
            if (i != strings.length - 1) {
                result += " ";
            }
        }
        return result;
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
