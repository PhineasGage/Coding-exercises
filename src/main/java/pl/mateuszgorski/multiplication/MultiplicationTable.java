package pl.mateuszgorski.multiplication;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MultiplicationTable {

    /* Checks if the input value is a integer, and is less then 12. */

    public static int getAndValidateTableSize(int size) {
        boolean notInt = true;
        while (notInt) {
            try {
                if (size <= 12 && size > 0) {
                    notInt = false;
                    return size;
                } else {
                    throw new IllegalArgumentException("The number is out of bounds");
                }

            } catch (InputMismatchException e) {
                System.out.println("Please enter correct number");
            }
        }
        return 0;
    }

    /* Prints Multiplication table with int size as a parameter  */
    public static String[][] createMultiplicationTableArray(int size) {
        String[][] multiplicationArray = new String[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                multiplicationArray[i][j] = String.format("%7s", (i + 1) * (j + 1));
            }
        }
        return multiplicationArray;
    }


    public static void showArray(String[][] array) {
        for (String[] j : array) {
            for (String intString : j) {
                System.out.print(intString);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.println("Please enter a number between 1 and 12");
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int number = getAndValidateTableSize(size);
        String[][] test = createMultiplicationTableArray(number);
        showArray(test);
    }
}







