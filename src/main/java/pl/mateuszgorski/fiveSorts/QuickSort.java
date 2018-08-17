package pl.mateuszgorski.fiveSorts;

import static pl.mateuszgorski.fiveSorts.Main.*;

public class QuickSort implements SortingMethod {

    public int[] sort(int[] intArray) {
        if ((intArray == null) || (intArray.length == 0)) {
            throw new IllegalArgumentException();
        }
        partition(intArray, 0, intArray.length - 1);
        return intArray;

    }

    private static void partition(int[] intArray, int min, int max) {
        if (min == max) {
            return;
        }
        int smallerIndex = min;
        int pivot = intArray[max];
        for (int i = min; i < max; i++) {
            if (intArray[i] <= pivot) {
                int temp = intArray[i];
                intArray[i] = intArray[smallerIndex];
                intArray[smallerIndex] = temp;
                smallerIndex++;
            }
        }
        int temp = pivot;
        intArray[max] = intArray[smallerIndex];
        intArray[smallerIndex] = temp;

        if (smallerIndex > 0) {
            partition(intArray, min, smallerIndex - 1);
        }
        partition(intArray, smallerIndex, max);

    }

    public static void main(String[] args) {
        int[] test = createArray(100);
        printArray(test);
        new QuickSort().sort(test);
        printArray(test);

    }
}
