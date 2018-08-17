package pl.mateuszgorski.pascal;


import java.util.Scanner;

public class PascalTriangle {
    private static double factorial(int number) {
        double factorial = 1;
        for (int i = 1; i <= number; i++) {
            factorial *= i;
        }
        return factorial;
    }

    /*calculates value of a element of Pascal triangle, according to int "row" and int "place
    params.*/
    private static double returnPascalTriangleElement(int row, int place) {
        double element = factorial(row) / ((factorial(place) * factorial(row - place)));
        return element;
    }

    /* Creates a Array of all Pascal Triangle elements */

    public static String[] createPascalTriangleArray(int row) {
        if (row > 0) {
            int arrayElement = 0;
            String[] pascalTriangleArray = new String[row];
            for (int i = 0; i < row; i++) {
                pascalTriangleArray[i] = "";
            }
            for (int j = 0; j < row; j++) {
                for (int k = 0; k < row - j - 1; k++) {
                    pascalTriangleArray[arrayElement] += String.format("%5s", " ");
                }
                for (int l = 0; l <= j; l++) {
                    pascalTriangleArray[arrayElement] += String.format("%5.0f%5s", returnPascalTriangleElement(j, l), " ");
                }
                arrayElement++;
            }
            return pascalTriangleArray;
        } else {
            throw new IllegalArgumentException("Input should be higher then zero!");
        }
    }

    private static void showArray(String[] array) {
        for (String j : array) {
            System.out.println(j);
        }
    }

    public static void main(String[] args) {
        System.out.println("Enter number of rows");
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        String[] test = createPascalTriangleArray(row);
        showArray(test);
    }
}
