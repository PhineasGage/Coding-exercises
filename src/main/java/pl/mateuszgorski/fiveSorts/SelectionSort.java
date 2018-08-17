package pl.mateuszgorski.fiveSorts;

import static pl.mateuszgorski.fiveSorts.Main.*;

public class SelectionSort implements SortingMethod {

    public int[] sort(int[] intArray) {
        if ((intArray == null) || (intArray.length == 0)) {
            throw new IllegalArgumentException();
        }
        for (int l = 0; l < intArray.length; l++) {
            int arrayMinValue = intArray[l];
            int arrayMinValueIndex = l;
            for (int m = l; m < intArray.length; m++) {
                if (intArray[m] < intArray[l] && intArray[m] < arrayMinValue) {
                    arrayMinValue = intArray[m];
                    arrayMinValueIndex = m;
                }
            }
            intArray[arrayMinValueIndex] = intArray[l];
            intArray[l] = arrayMinValue;
        }
        return intArray;

    }

    public static void main(String[] args) {
        int[] intArray = createArray(100);
        printArray(intArray);
        new SelectionSort().sort(intArray);
        printArray(intArray);
    }
}