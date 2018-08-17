package pl.mateuszgorski.fiveSorts;

import java.util.Arrays;

import static pl.mateuszgorski.fiveSorts.Main.*;

public class ArraysSort implements SortingMethod {

    public int[] sort(int[] intArray) {
        if ((intArray == null) || (intArray.length == 0)) {
            throw new IllegalArgumentException("Input array is null or has zero length");
        }
        Arrays.sort(intArray);
        return intArray;
    }

    public static void main(String[] args) {
        int[] test = createArray(100);
        printArray(test);
        new ArraysSort().sort(test);
        printArray(test);

    }
}