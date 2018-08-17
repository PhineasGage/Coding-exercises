package pl.mateuszgorski.fiveSorts;

public class MergeSort implements SortingMethod {
    int[] arrayA;
    int[] arrayB;

    public int[] sort(int[] arrayToSort) {
        if ((arrayToSort == null) || (arrayToSort.length == 0)) {
            throw new IllegalArgumentException();
        }
        this.arrayA = arrayToSort;
        this.arrayB = new int[arrayToSort.length];
        int arrayBegins = 0;
        int arrayEnds = arrayToSort.length - 1;
        splitAndMergeArray(arrayBegins, arrayEnds);
        return arrayToSort;
    }

    private void splitAndMergeArray(int arrayBegins, int arrayEnds) {
        if (arrayEnds > arrayBegins) {
            int firstHalfBegins = arrayBegins;
            int firstHalfEnds = arrayBegins + (arrayEnds - arrayBegins) / 2;
            int secondHalfEnds = arrayEnds;
            splitAndMergeArray(firstHalfEnds + 1, secondHalfEnds);
            splitAndMergeArray(firstHalfBegins, firstHalfEnds);
            mergeArrays(firstHalfBegins, firstHalfEnds, secondHalfEnds);
        }
    }

    private void mergeArrays(int firstHalfBegins, int firstHalfEnds, int secondHalfEnds) {
        int pointerA = 0;
        int pointerB = 0;
        for (int i = firstHalfBegins; i <= secondHalfEnds; i++) {
            if (pointerA == firstHalfEnds - firstHalfBegins + 1) {
                arrayB[i] = arrayA[firstHalfEnds + 1 + pointerB];
                pointerB++;
                continue;
            }
            if (pointerB == secondHalfEnds - firstHalfEnds) {
                arrayB[i] = arrayA[firstHalfBegins + pointerA];
                pointerA++;
                continue;
            }
            if (arrayA[firstHalfBegins + pointerA] <= arrayA[firstHalfEnds + 1 + pointerB]) {
                arrayB[i] = arrayA[firstHalfBegins + pointerA];
                pointerA++;
            } else {
                arrayB[i] = arrayA[firstHalfEnds + 1 + pointerB];
                pointerB++;
            }
        }
        for (int j = firstHalfBegins; j < secondHalfEnds + 1; j++) {
            arrayA[j] = arrayB[j];
        }
    }
}