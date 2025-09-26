package com.pluralsight;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CalculatorApp {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            List<Double> numbers = new ArrayList<>();
            List<String> operators = new ArrayList<>();

            // Read user first number input:
            System.out.print("Enter the first number: ");
            while (!input.hasNextDouble()) {
                System.out.print("Enter a number: ");
                input.next();
            }
            numbers.add(input.nextDouble());

            // Read operator input
            // Continue till user is read for total: '='
            while (true) {
                System.out.print("Enter operation (+, -, *, /) or = : ");
                String operation = input.next().trim();

                if (operation.equals("=")) break;

                if (!operation.equals("+") && !operation.equals("-") && !operation.equals("*") && !operation.equals("/")) {
                    System.out.println("Invalid operation. Try again.");
                    continue;
                }

                operators.add(operation);

                System.out.print("Enter the next number: ");
                while (!input.hasNextDouble()) {
                    System.out.print("Enter a valid number: ");
                    input.next();
                }
                numbers.add(input.nextDouble());
            }

            // If there is only one number and no operation:
            if (operators.isEmpty()) {
                System.out.println("Equals: " + numbers.getFirst()); //starting — numbers.get(0)
                return;
            }

            // Solve left to right: operators[i] applies to numbers[i] and numbers[i+1]
            // Keep a running total starting with numbers.getFirst
            // — aka numbers.get(0).
            double total = numbers.getFirst();
            for (int i = 0; i < operators.size(); i++) {
                String operation = operators.get(i);
                double nextNum = numbers.get(i + 1);

                switch (operation) {
                    case "+" -> total += nextNum;
                    case "-" -> total -= nextNum;
                    case "*" -> total *= nextNum;
                    case "/" -> {
                        if (nextNum == 0) {
                            System.out.println("Error: Undefined.");
                            return;
                        }
                        total /= nextNum;
                    }
                }
            }

            System.out.println("Equals: " + total);
        }
    }
}