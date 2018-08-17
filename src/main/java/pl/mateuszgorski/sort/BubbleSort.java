package pl.mateuszgorski.sort;

public class BubbleSort {

    private static int[] createArray() {
        int[] intArray = new int[100];
        for (int j = 0; j < 100; j++) {
            intArray[j] = (int) (Math.random() * 100);
        }
        return intArray;
    }

    private static void printArray(int[] intarray) {
        for (int k : intarray) {
            System.out.print(k + " ");
        }
        System.out.println();
    }

    private static int[] sort(int[] intArray) {
        for (int l = 1; l < intArray.length; l++) {
            for (int m = l; m > 0; m--) {
                if (intArray[m] < intArray[m - 1]) {
                    int temp = intArray[m - 1];
                    intArray[m - 1] = intArray[m];
                    intArray[m] = temp;
                }
            }
        }
        return intArray;
    }

    public static void main(String[] args) {
        int[] intArray = createArray();
        System.out.println("Unsorted Array ");
        printArray(intArray);

        System.out.println("Sorted Array ");
        sort(intArray);
        printArray(intArray);
    }
}