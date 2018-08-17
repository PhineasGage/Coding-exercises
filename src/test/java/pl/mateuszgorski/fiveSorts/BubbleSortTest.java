package pl.mateuszgorski.fiveSorts;

import static org.junit.Assert.*;

public class BubbleSortTest extends SortingTestBase {

    @Override
    public SortingMethod getSortingMethod() {
        return new BubbleSort();
    }
}