package pl.mateuszgorski.fiveSorts;

import java.util.Random;

public class Main {

    public static int[] createArray(int size) {
        int[] intArray = new int[size];
        Random random = new Random();
        for (int j = 0; j < intArray.length; j++) {
            intArray[j] = random.nextInt();
        }
        return intArray;
    }


    public static void printArray(int[] intarray) {
        for (int k : intarray) {
            System.out.print(k + " ");
        }
        System.out.println();
    }
}
