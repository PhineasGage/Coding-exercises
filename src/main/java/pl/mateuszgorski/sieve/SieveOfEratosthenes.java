package pl.mateuszgorski.sieve;

import java.util.Scanner;

public class SieveOfEratosthenes {

    private static int[] sieve(int maximumNumber) {
        int[] intArray = new int[maximumNumber];
        for (int i = 0; i < maximumNumber; i++) {
            intArray[i] = i + 1;
            for (int j = 1; j <= maximumNumber; j++) {
                if (intArray[i] % j == 0 && intArray[i] != 1 && j != 1 && intArray[i] != j) {
                    intArray[i] = 0;
                }
            }
        }
        return intArray;
    }

    private static void printArray(int[] intArray) {
        for (int i : intArray) {
            if (i != 0) {
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Please input number: ");
        Scanner scanner = new Scanner(System.in);
        int[] test = sieve(scanner.nextInt());
        printArray(test);
    }
}
