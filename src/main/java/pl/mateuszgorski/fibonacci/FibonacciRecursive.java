package pl.mateuszgorski.fibonacci;

import java.util.Scanner;

public class FibonacciRecursive {

    private static long fibonacci(int fibonacciNumberInOrder) {
        if (fibonacciNumberInOrder == 1 || fibonacciNumberInOrder == 2) {
            return 1;
        }
        return fibonacci(fibonacciNumberInOrder - 1) + fibonacci(fibonacciNumberInOrder - 2);
    }

    public static void main(String[] args) {
        System.out.print("Which fibonacci number to print: ");
        Scanner scanner = new Scanner(System.in);
        long number = fibonacci(scanner.nextInt());
        System.out.println(number);
    }
}
