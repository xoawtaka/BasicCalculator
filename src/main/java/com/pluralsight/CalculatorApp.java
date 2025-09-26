package com.pluralsight;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CalculatorApp {
    public static void main(String[] args) {

        //Use the scanner to capture user input
        Scanner input = new Scanner(System.in);
        double total;
        {
            List<Double> numbers = new ArrayList<>();
            List<String> operators = new ArrayList<>();

        /*Enter the First Number:
        Read the number user inputs
         */
            System.out.print("Enter the first number: ");
            numbers.add(input.nextDouble());

            //Side Note: I want a more efficient reading of the number
            // Read numbers until user decides to stop inputting:
            while (!numbers.isEmpty()) {
                System.out.print("Enter operation: (+, -, *, /, =) ");
                String operation = input.next();

                if (operation.equals("=")) {
                    break; //User stops inputting — Calculator solves
                }

                operators.add(operation);
                System.out.print("Enter the next number: ");
                numbers.add(input.nextDouble());
            }
            //Include other operating systems for output:
            total = numbers.getFirst();
            for (int i = 0; i < operators.size(); i++) {
                String operation = operators.get(i);
                double nextNumb = numbers.get(i);


                switch (operation) {
                    case "+" -> total += nextNumb;
                    case "-" -> total -= nextNumb;
                    case "*" -> total *= nextNumb;
                    case "/" -> {
                        if (nextNumb == 0) {
                            throw new ArithmeticException("Cannot divide by zero: Undefined");
                        }
                        total /= nextNumb;
                    }
                    default -> throw new IllegalStateException("Unexpected value: " + operation);
                }
            } System.out.println("Equals: " + total);
        }
    }
}
