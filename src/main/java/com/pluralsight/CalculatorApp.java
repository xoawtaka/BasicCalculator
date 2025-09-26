package com.pluralsight;

import javax.management.AttributeList;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CalculatorApp {
    public static void main(String[] args) {

        //Use the scanner to capture user input
        Scanner input = new Scanner(System.in); {
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
            System.out.print("Enter operation: (/, *, +, -)");
            String operation = input.next();

            if (operation.equals("=")) {
                break; //User stops inputting — Calculator solves
            }

            operators.add(operation);
            System.out.print("Enter the next number: ");
            numbers.add(input.nextDouble());
        }
        //Include other operating systems for output:
        double total = 0;
            for (Double aDouble : numbers) {
                String operation = aDouble.toString();
                double nextNumber = aDouble;

                switch (operation) {
                    case "/" -> {
                        double number = nextNumber;
                        while (number > 0) {
                            number = number / number;
                            total = total + number;
                        }
                    }
                    case "*" -> {
                        double number = nextNumber;
                        while (number > 0) {
                            number = number * number;
                            total = total + number;
                        }
                    }
                    case "+" -> {
                        double number = nextNumber;
                        while (number > 0) {
                            number = number + number;
                            total = total + number;
                        }
                    }
                    case "-" -> {
                        double number = nextNumber;
                        while (number > 0) {
                            number = number - number;
                            total = total - number;
                        }
                    }
                }
            }



        }
    }
}
