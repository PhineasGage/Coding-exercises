package pl.mateuszgorski.fiveSorts;

import static pl.mateuszgorski.fiveSorts.Main.*;

public class BubbleSort implements SortingMethod {

    public int[] sort(int[] intArray) {
        if ((intArray == null) || (intArray.length == 0)) {
            throw new IllegalArgumentException();
        }
        for (int i = 1; i < intArray.length; i++) {
            for (int j = i; j > 0; j--) {
                if (intArray[j] < intArray[j - 1]) {
                    int temp = intArray[j - 1];
                    intArray[j - 1] = intArray[j];
                    intArray[j] = temp;
                }
            }
        }
        return intArray;

    }

    public static void main(String[] args) {
        int[] intArray = createArray(100);
        System.out.println("Unsorted Array ");
        printArray(intArray);

        new BubbleSort().sort(intArray);
        System.out.println("Sorted Array ");
        printArray(intArray);
    }
}