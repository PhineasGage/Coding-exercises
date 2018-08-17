package pl.mateuszgorski.foobar;


import java.util.Scanner;

public class FooBar {

    public static String[] createFooBarArray(int number) {
        if (number > 1) {
            String[] fooBarArray = new String[number];
            for (int j = 0; j < number; j++) {
                fooBarArray[j] = createArrayElement(j + 1);
            }
            return fooBarArray;
        } else {
            throw new IllegalArgumentException("Input should be higer then zero!");
        }
    }

    public static String createArrayElement(int number) {
        return number + " " + (number % 3 == 0 ? "Foo" : "") + (number % 5 == 0 ? "Bar" : "");
    }

    public static void showArray(String[] array) {
        for (String j : array) {
            System.out.println(j);
        }
    }

    public static void main(String[] args) {
        System.out.println("Pick a number:");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        String[] testArray = createFooBarArray(number);
        showArray(testArray);
    }

}