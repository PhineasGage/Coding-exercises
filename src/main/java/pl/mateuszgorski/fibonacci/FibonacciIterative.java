package pl.mateuszgorski.fibonacci;

import java.util.Scanner;

public class FibonacciIterative {

    private static long fibonacci(int fibonacciNumberInOrder) {
        long fibonacciNumberMinusTwo = 1;
        long fibonacciNumberMinusOne = 1;
        long fibonacciNumber = 0;
        if (fibonacciNumberInOrder < 3) {
            return 1;
        } else {
            for (int i = 2; i < fibonacciNumberInOrder; i++) {
                fibonacciNumber = fibonacciNumberMinusOne + fibonacciNumberMinusTwo;
                fibonacciNumberMinusTwo = fibonacciNumberMinusOne;
                fibonacciNumberMinusOne = fibonacciNumber;
            }
        }
        return fibonacciNumber;
    }

    public static void main(String[] args) {
        System.out.print("Which fibonacci number to print: ");
        Scanner scanner = new Scanner(System.in);
        long number = fibonacci(scanner.nextInt());
        System.out.println(number);

    }
}
