package com.aca.calculator;

import java.util.Scanner;

public class Calculator6 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please type the expression");
        //( ( 3 + 4 ) * 2 ) - 1
//        String expression = scanner.nextLine();
        String expression = "( ( 3 + 4 + 3 ) * 2 ) - 1";
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

    static String findMostPrioritizedSubExpression(String expression) {
        if (expression.contains("(")) {
            String[] split = expression.split(" ");
            int openingBracketIndex = -1;
            int closingBracketIndex = -1;
            for (int i = 0; i < split.length; i++) {
                if (split[i].equals("(")) {
                    openingBracketIndex = i;
                } else if (split[i].equals(")") && i > openingBracketIndex) {
                    closingBracketIndex = i;
                    break;
                }
            }
            String result = "";
            for (int i = openingBracketIndex; i < closingBracketIndex + 1; i++) {
                result += split[i];
                if (i != closingBracketIndex) {
                    result += " ";
                }
            }
            return result;
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

}
